package by.byshnev.springmvc.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatior(@RequestParam("a") int a,
                              @RequestParam("b") int b,
                              @RequestParam("action") String action,
                              Model model) {

        double result;

        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "division":
                result = a / (double)b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("calc", result);

//        if (action.equals("multiplication")) {
//            action = String.valueOf(a * b);
//        }
//        if (action.equals("addition")) {
//            action = String.valueOf(a + b);
//        }
//        if (action.equals("subtraction")) {
//            action = String.valueOf(a - b);
//        }
//        if (action.equals("division")) {
//            action = String.valueOf(a / b);
//        }
//        model.addAttribute("calc", action);

        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
