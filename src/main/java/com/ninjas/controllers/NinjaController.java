package com.ninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ninjas.models.Ninja;
import com.ninjas.services.NinjaService;

@Controller
public class NinjaController {

	private static NinjaService ninserv;

	public NinjaController(NinjaService ninserv) {
		this.ninserv = ninserv;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("ninjas", ninserv.getAll());
		return "index.jsp";
	}

	@PostMapping("/ninjas")
	public String create(@ModelAttribute("ninja") Ninja ninja) {
		ninserv.create(ninja);
		return "redirect:/";
	}
}
