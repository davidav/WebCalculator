package ru.daff.calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalcController {
    @GetMapping("/calc")
    public String calculate(@RequestParam("first") int a,
                            @RequestParam("second") int b,
                            @RequestParam("action") String action,
                            Model model) {
        double c = calculateResult(a, b, action);
        model.addAttribute("result", c);
        return "calc/result";
    }

    private double calculateResult(int a, int b, String action) {
        double c = 0;
        switch (action) {
            case "ADDITION":
                c = a + b;
                break;
            case "SUBTRACTION":
                c = a - b;
                break;
            case "MULTIPLICATION":
                c = a * b;
                break;
            case "DIVISION":
                c = a / (double)b;
        }
        return c;
    }

    @GetMapping("/")
    public String calculator() {
        return "calc/calculator";
    }

}