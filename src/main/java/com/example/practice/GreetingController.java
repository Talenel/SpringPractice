package com.example.practice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/greeting")
public class GreetingController {
    @Autowired
    private GreetRepository greetRepository;

    
    
    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }
    
    @PostMapping("/greeting")
    public String greetingSubmit(@Valid Greeting greeting, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        greetRepository.save(greeting);
        return "result";
    }   
    /*
    @GetMapping(path="/add")
    public @ResponseBody String addNewGreet(@RequestParam String content)
            {
                Greeting g = new Greeting();
                g.setContent(content);
                greetRepository.save(g);
                return "Saved";
            }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Greeting> getAllUsers()
    {
        return greetRepository.findAll();
    }
    */
}