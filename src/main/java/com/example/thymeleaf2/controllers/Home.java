package com.example.thymeleaf2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {
    List<String> listOfInputs = new ArrayList<>();

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("listOfInputs", listOfInputs);
        return "contact";
    }

    @PostMapping("/contact")
    public String postContact(Model model, @RequestParam("input") String input) {
        if( !input.isEmpty() || !input.equals(""))
            listOfInputs.add(input);
        System.out.println("input was:"+ input);
        return "redirect:/contact";
    }
    @PostMapping("/delete")
    public String deleteInputFromList(@RequestParam("index") String input){
        int index = Integer.valueOf(input);
        System.out.println("index:" + index);
        listOfInputs.remove(index);
        System.out.println(listOfInputs);
        return "redirect:/contact";
    }
}
