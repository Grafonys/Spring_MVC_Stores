package com.homework.spring_mvc_stores.controllers;

import com.homework.spring_mvc_stores.models.Store;

import com.homework.spring_mvc_stores.services.StoreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class StoreController {

    private final StoreServiceImpl storeService;

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("stores", storeService.getAll());
        return "stores";
    }

    @GetMapping("/search")
    public String getSearchResult(@RequestParam String search_input,
                                  @RequestParam String search_option,
                                  Model model) {
        List<Store> stores;

        switch (search_option) {
            case "Name" -> stores = storeService.findByName(search_input);
            case "Category" -> stores = storeService.findByCategory(search_input);
            case "Address" -> stores = storeService.findByAddress(search_input);
            default -> stores = null;
        }
        model.addAttribute("stores", stores);
        return "stores";
    }

    @PostMapping("/delete")
    public String deleteStore(@RequestParam Integer id) {
        storeService.delete(id);
        return "redirect:/";
    }
}
