package com.Aziz.maison.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Aziz.maison.entities.Personne;
import com.Aziz.maison.entities.Maison;
import com.Aziz.maison.repos.MaisonRepository;

@Service
public class MaisonServiceImpl implements MaisonService {

	@Autowired
	MaisonRepository maisonRepository;

	@Override
	public Maison saveMaison(Maison p) {
		return maisonRepository.save(p);
	}

	@Override
	public Maison updateMaison(Maison p) {
		return maisonRepository.save(p);
	}

	@Override
	public void deleteMaison(Maison p) {
		maisonRepository.delete(p);

	}

	@Override
	public void deleteMaisonById(Long id) {
		maisonRepository.deleteById(id);

	}

	@Override
	public Maison getMaison(Long id) {
		return maisonRepository.findById(id).get();
	}

	@Override
	public List<Maison> getAllMaisons() {

		return maisonRepository.findAll();
	}

	
	@Override
	public Page<Maison> getAllMaisonsParPage(int page, int size) {
		return maisonRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Maison> findByAdresse(String nom) {
		return maisonRepository.findByAdresse(nom);
	}

	@Override
	public List<Maison> findByAdresseContains(String nom) {
		return maisonRepository.findByAdresseContains(nom);
	}

	@Override
	public List<Maison> findByType(String nom, String type) {
		return maisonRepository.findByType(nom, type);
	}

	@Override
	public List<Maison> findByPersonne(Personne personne) {
		return maisonRepository.findByPersonne(personne);
	}

	@Override
	public List<Maison> findByPersonneIdPers(Long id) {
		return maisonRepository.findByPersonneIdPers(id);
	}

	@Override
	public List<Maison> findByOrderByAdresseAsc() {
		return maisonRepository.findByOrderByAdresseAsc();
	}

	@Override
	public List<Maison> trierMaisonsType() {
		return maisonRepository.trierMaisonsType();
	}

}
