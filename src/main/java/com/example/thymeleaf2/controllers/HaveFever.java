package com.example.thymeleaf2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HaveFever {

    @GetMapping("/havefever")
    public String haveFeverIndex(){
        return "havefever";
    }
    @PostMapping("/temperature")
    public String checkFever(@RequestParam("degree") String input, RedirectAttributes redirectAttributes){
        double degree = Double.valueOf(input);
        System.out.println("degree is:" + degree);
        String message;
        String messageType;
        if(degree<36.5){
            message= "You're fine!";
            messageType = "success";
        }
        else if(degree>=36.5 && degree<38.1){
            message= "you have a fever";
            messageType = "warning";
        }
        else {
            message = "you have hyperthermia";
            messageType = "danger";
        }
            redirectAttributes.addFlashAttribute("message", message);
        redirectAttributes.addFlashAttribute("type", messageType);
        return "redirect:/havefever";
    }
}
