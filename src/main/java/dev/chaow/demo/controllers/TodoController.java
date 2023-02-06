package dev.chaow.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dev.chaow.demo.forms.TodoCreateForm;

@Controller
public class TodoController {

    @GetMapping("todo")
    public String index(Model model) {
        
        return "todos/index";
    }
    
    @PostMapping("todo/create")
    public String create(Model model,TodoCreateForm form) {
    	
    	model.addAttribute("todo",form);
    	
        return "todos/created";
    }
}