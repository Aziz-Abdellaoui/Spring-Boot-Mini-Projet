package com.Aziz.maison.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Aziz.maison.entities.Maison;
import com.Aziz.maison.service.MaisonService;

@Controller
public class MaisonController {
	@Autowired
	MaisonService maisonService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("maison", new Maison());
	modelMap.addAttribute("mode", "new");
	return "formMaison";
	}
	@RequestMapping("/saveMaison")
	public String saveProduit(@Valid Maison maison,
	BindingResult bindingResult)

	{
	if (bindingResult.hasErrors()) return "formMaison";
	maisonService.saveMaison(maison);
	return "formMaison";
	}
	
	@RequestMapping("/ListeMaisons")
	public String listeMaisons(ModelMap modelMap,
	     @RequestParam (name="page",defaultValue = "0") int page,
	     @RequestParam (name="size", defaultValue = "3") int size)
	{
		
		Page<Maison> mais = maisonService.getAllMaisonsParPage(page, size);
		modelMap.addAttribute("maison", mais);

		modelMap.addAttribute("pages", new int[mais.getTotalPages()]);

		modelMap.addAttribute("currentPage", page);
		return "listeMaisons";
	}
	
	@RequestMapping("/supprimerMaison")
	public String supprimerMaison(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "3") int size)

	{
	maisonService.deleteMaisonById(id);
	Page<Maison> mais = maisonService.getAllMaisonsParPage(page,

	size);

	modelMap.addAttribute("maison", mais);
	modelMap.addAttribute("pages", new int[mais.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeMaisons";
	}
	
	@RequestMapping("/modifierMaison")
	public String editerMaison(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Maison m= maisonService.getMaison(id);
	modelMap.addAttribute("maison", m);
	modelMap.addAttribute("mode", "edit");
	return "formMaison";
	}
	@RequestMapping("/updateMaison")
	public String updateMaison(@ModelAttribute("maison") Maison maison,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date 
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateAchat = dateformat.parse(String.valueOf(date));
	maison.setDateAchat(dateAchat);
	maisonService.updateMaison(maison);
	List<Maison> mais = maisonService.getAllMaisons();
	modelMap.addAttribute("maison", mais);
	return "listeMaisons";
	}
	}

