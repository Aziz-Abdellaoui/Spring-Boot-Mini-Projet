package com.Aziz.maison.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Aziz.maison.entities.Maison;
import com.Aziz.maison.service.MaisonService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class MaisonRESTController {
	@Autowired
	MaisonService maisonService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Maison> getAllMaisons() {
		return maisonService.getAllMaisons();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Maison getMaisonById(@PathVariable("id") Long id) {
		return maisonService.getMaison(id);

	}

	@RequestMapping(method = RequestMethod.POST)
	public Maison createMaison(@RequestBody Maison maison) {
		return maisonService.saveMaison(maison);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Maison updateMaison(@RequestBody Maison maison) {
		return maisonService.updateMaison(maison);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteMaison(@PathVariable("id") Long id) {
		maisonService.deleteMaisonById(id);
	}

	@RequestMapping(value = "/maispers/{idPers}", method = RequestMethod.GET)
	public List<Maison> getMaisonsByIdPers(@PathVariable("idPers") Long idPers) {
		return maisonService.findByPersonneIdPers(idPers);
	}
}