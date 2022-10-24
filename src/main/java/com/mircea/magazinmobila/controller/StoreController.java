package com.mircea.magazinmobila.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mircea.magazinmobila.StoreConstants;
import com.mircea.magazinmobila.entity.Item;
import com.mircea.magazinmobila.service.StoreService;

@Controller
@RequestMapping("/magazin")
public class StoreController {

    @Autowired
    StoreService storeService;

    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("categories", StoreConstants.getCategories());
        model.addAttribute("item", new Item());
        return "form";
    }

    @GetMapping("/inventar")
    public String getStoc(Model model) {
        model.addAttribute("items", storeService.getItems());
        return "inventar";
    }

    @PostMapping("/handleSubmit")
    public String handleSubmit(@Valid Item item, BindingResult result, RedirectAttributes redirectAttributes) {
        if (item.getPrice() < item.getDiscount()) {
            result.rejectValue("price", "", "Pretul nu poate fi mai mic ca si discountul");
        }
        if (result.hasErrors()) return "form";
        redirectAttributes.addFlashAttribute("status", storeService.addItem(item)); 
        return "redirect:/magazin/inventar";
    }


    @GetMapping("/update")
    public String updateItem(Model model, @RequestParam String id) {
        model.addAttribute("item", storeService.getItemById(id));
        return "form";
    }
    
    @GetMapping("/delete")
    public String deleteItem(@RequestParam String id) {
        storeService.deleteItem(id);
        return "redirect:/magazin/inventar";
    }

}
