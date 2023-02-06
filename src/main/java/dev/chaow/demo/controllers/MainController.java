package dev.chaow.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(Model model) {
		String[] todos = new String[] {
			"aaaa","bbbb","ccccc"
		};
		model.addAttribute("yourName", "John Doe");
		model.addAttribute("todoList",todos);
		return "index";
	} 
	
	@GetMapping("/hello")
	public String hello(Model model) {
		return "hello";
	}
	
	@GetMapping("/hello2")
	public String hello2(Model model,
			@RequestParam("name") String name,
			@RequestParam("age") int age
		) {
			model.addAttribute("name",name);
			model.addAttribute("age",age);
			return "hello2";
	}
	

	@GetMapping("/hello3")
	public String hello3(Model model,
			@RequestParam("name") String name,
			@RequestParam("age") Optional<Integer> age
		) {
			model.addAttribute("name",name);
			model.addAttribute("age",age);
			return "hello3";
	}
	
	

	@GetMapping("/hello4/{name}")
	public String hello4(Model model,
			@PathVariable("name") String name
			){
				model.addAttribute("name",name);
				
				return "hello4";
			}
			
	@GetMapping({
		"/hello5/{name}",
		"/hello5/{name}/{age}"
	})
	
	public String hello5(
			Model model,
			@PathVariable("name") String name,
			@PathVariable("age") Optional<Integer> age
			) {
		
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "hello3";
	}

}

