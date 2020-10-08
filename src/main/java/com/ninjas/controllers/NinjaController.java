package com.ninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("newNinja", new Ninja());
		return "index.jsp";
	}

	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("ninjas", ninserv.getAll());
			return "index.jsp";
		} else {
			ninserv.create(newNinja);
			return "redirect:/";
		}

	}

	@GetMapping("/ninjas/{id}")
	public String ninjaDetails(@PathVariable("id") Long id, Model model) {
		model.addAttribute("singleNinja", ninserv.getOne(id));
		return "Ninja.jsp";
	}

	@PostMapping("/ninjas/{id}/update")
	public String updateNinja(@PathVariable("id") Long id, @Valid @ModelAttribute("singleNinja") Ninja singleNinja,
			BindingResult result) {
		if (result.hasErrors()) {
			return "ninja.jsp";
		} else {
			ninserv.update(singleNinja, id);
			return "redirect:/";
		}
	}

	@GetMapping("/ninja/destroy/{id}")
	public String destroy(@PathVariable("id") Long id, @Valid @ModelAttribute("singleNinja") Ninja singleNinja,
			BindingResult result) {
		ninserv.destroy(singleNinja, id);
		return "redirect:/";
	}

	@GetMapping("ninja/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ninja", ninserv.getOne(id));
		return "show.jsp";
	}
}
