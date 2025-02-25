package jpa.map.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jpa.map.model.Item;
import jpa.map.service.ItemService;

@Controller
class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String getItems(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "item";
    }

    @PostMapping("/items")
    public String saveItem(@RequestParam("name") String name, @RequestParam("price") double price) {
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        itemService.saveItem(item);
        return "redirect:/items";
    }
}