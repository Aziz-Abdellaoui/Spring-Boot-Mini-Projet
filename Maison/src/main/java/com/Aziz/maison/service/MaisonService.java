package com.Aziz.maison.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Aziz.maison.entities.Personne;
import com.Aziz.maison.entities.Maison;

public interface MaisonService {
	Maison saveMaison(Maison p);

	Maison updateMaison(Maison p);

	void deleteMaison(Maison p);

	void deleteMaisonById(Long id);

	Maison getMaison(Long id);

	List<Maison> getAllMaisons();

	List<Maison> findByAdresse(String nom);

	List<Maison> findByAdresseContains(String nom);

	List<Maison> findByType(String nom, String type);

	List<Maison> findByPersonne(Personne personne);

	List<Maison> findByPersonneIdPers(Long id);

	List<Maison> findByOrderByAdresseAsc();

	List<Maison> trierMaisonsType();

	Page<Maison> getAllMaisonsParPage(int page, int size);

}