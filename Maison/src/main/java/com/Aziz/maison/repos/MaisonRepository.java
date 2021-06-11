package com.Aziz.maison.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.Aziz.maison.entities.Personne;
import com.Aziz.maison.entities.Maison;

@RepositoryRestResource(path = "rest")
public interface MaisonRepository extends JpaRepository<Maison, Long> {

	List<Maison> findByAdresse(String nom);

	List<Maison> findByAdresseContains(String nom);
	
	
	@Query("select m from Maison m where m.adresse like %:nom and m.type like %:type")
	List<Maison> findByType (@Param("nom") String nom,@Param("type") String type);
	
	@Query("select m from Maison m where m.personne = ?1")
	List<Maison> findByPersonne (Personne personne);
	
	List<Maison> findByPersonneIdPers(Long id);
	
	List<Maison> findByOrderByAdresseAsc();
	
	@Query("select m from Maison m order by m.adresse ASC, m.type DESC")
	List<Maison> trierMaisonsType();
}
