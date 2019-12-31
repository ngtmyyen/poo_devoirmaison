package com.example.tp5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.tp5.modele.AdresseRepository;

@Controller
public class AddressController {

    @Autowired
    AdresseRepository adresseRepository;

    @GetMapping("/adresses") 
    public String showAdresses(Model model) {
        model.addAttribute("allAdresses", adresseRepository.findAll());
        return "adresses"; // nom du fichier html
    }
    @GetMapping("/adresse")
    public String showFormulaire(Model model) {
        return "adresse"; // nom du fichier html
    }
}
