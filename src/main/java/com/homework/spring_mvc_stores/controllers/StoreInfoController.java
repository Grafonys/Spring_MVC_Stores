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


@Controller
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreInfoController {

    private final StoreServiceImpl storeService;

    @GetMapping
    public String getStoreInfoPage(@RequestParam Integer id,
                                   @RequestParam(required = false) Boolean isEdit,
                                   Model model) {
        model.addAttribute("store",
                id == 0
                ? new Store()
                : storeService.findById(id).get());
        model.addAttribute("isEdit", isEdit != null);
        model.addAttribute("categories", StoreServiceImpl.VALID_CATEGORIES);
        return "store_info";
    }

    @PostMapping("/save")
    public String saveStore(Store store) {
        storeService.save(store);
        return "redirect:/";
    }
}
