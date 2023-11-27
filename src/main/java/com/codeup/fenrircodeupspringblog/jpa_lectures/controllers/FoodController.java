package com.codeup.fenrircodeupspringblog.jpa_lectures.controllers;

import com.codeup.fenrircodeupspringblog.jpa_lectures.models.Food;
import com.codeup.fenrircodeupspringblog.jpa_lectures.repositories.FoodRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FoodController {

    private final FoodRepository foodDataAccessObject;

    public FoodController(FoodRepository foodDataAccessObject) {
        this.foodDataAccessObject = foodDataAccessObject;
    }


    //Above - we need to set up X number of fields for our Repositories (AdRepository, UserRepository, FoodRepository) and add them to the controller's constructor
    //Below : normal mappings and methos for GET and POST processing related to foods

    @GetMapping("/lunchTime")
    public String whatsForLunch(Model model){

        model.addAttribute("lunchItems", foodDataAccessObject.findAll());

        return "lunch";
    }

    @GetMapping("/lunchOrder")
    public String lunchOrderForm(Model model) {
        model.addAttribute("lunchItem", new Food());
        return "lunchOrderForm";
    }

    @PostMapping("/lunchOrder")
    public String createLunchItem(@ModelAttribute Food food) {
        foodDataAccessObject.save(food);
        return "redirect:/lunchTime";
    }

}
