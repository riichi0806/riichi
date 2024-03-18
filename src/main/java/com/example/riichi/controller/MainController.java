package com.example.riichi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.riichi.model.AddressModel;
import com.example.riichi.service.AddressService;

 
@Controller
public class MainController {
	@Autowired
	private AddressService AddressService;
 
 
@GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "こんにちは");
    return "createAccount";
  }

@GetMapping("/touroku/")
public ModelAndView add(AddressModel addressmodel, ModelAndView model)  {
    model.addObject("ginkou", addressmodel);
    model.setViewName("touroku");
return model;
  }
@PostMapping("/touroku/")
public String ginkou(@Validated @ModelAttribute @NonNull AddressModel AddressModel, RedirectAttributes result, ModelAndView model,
        RedirectAttributes redirectAttributes) {
    try {
        this.AddressService.save(AddressModel);
        redirectAttributes.addFlashAttribute("exception", "");

    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("exception", e.getMessage());
    }
    return "mop";

  }

}