package hdxian.itemservice.web.basic;

import hdxian.itemservice.domain.Item;
import hdxian.itemservice.domain.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // generate constructor with final properties
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        // put item list into model (maybe Map)
        model.addAttribute("items", items);
        // return logical view name (resolved by viewResolver)
        return "basic/items";
    }

    @PostConstruct
    public void init() {
        // called after DI
        Item item1 = new Item("testItem1", 10000, 10);
        Item item2 = new Item("testItem2", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);
    }

}
