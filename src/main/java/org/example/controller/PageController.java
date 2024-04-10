package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("")
@Slf4j
public class PageController {

    @GetMapping("/subPage")
    public String subPage(Model model) {
        model.addAttribute("a","123");
        return "subPage";
    }

    @GetMapping("/mainPage")
    public String mainPage(Model model) {
        model.addAttribute("a","123");
        return "mainPage";
    }
}
