package com.Aziz.maison;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.Aziz.maison.entities.Personne;
import com.Aziz.maison.entities.Maison;
import com.Aziz.maison.repos.MaisonRepository;
import com.Aziz.maison.service.MaisonService;

@SpringBootTest
class MaisonsApplicationTests {

	@Autowired
	private MaisonRepository maisonRepository;
	private MaisonService maisonService;

	@Test
	public void testCreateMaison() {
		Maison mais = new Maison("Jardins de Carthage", "villa", new Date());
		maisonRepository.save(mais);
	}

	@Test
	public void testFindMaison() {
		Maison m = maisonRepository.findById(1L).get();
		System.out.println(m);
	}

	@Test
	public void testUpdateMaison() {
		Maison m = maisonRepository.findById(1L).get();
		m.setType("maison");
		maisonRepository.save(m);

		System.out.println(m);
	}

	@Test
	public void testDeleteMaison() {
		maisonRepository.deleteById(1L);
	}

	@Test
	public void testFindAllMaisons() {
		List<Maison> mais = maisonRepository.findAll();

		for (Maison m : mais)
			System.out.println(m);

	}

	@Test
	public void testFindByAdresseContains() {
		Page<Maison> mais = maisonService.getAllMaisonsParPage(0, 2);
		System.out.println(mais.getSize());
		System.out.println(mais.getTotalElements());
		System.out.println(mais.getTotalPages());
		mais.getContent().forEach(m -> {
			System.out.println(m.toString());
		});
	}

	@Test
	public void testFindByAdresse() {
		List<Maison> mais = maisonRepository.findByAdresse("Carthage");

		for (Maison m : mais) {
			System.out.println(m);
		}

	}

	@Test
	public void testfindByAdresseContains() {
		List<Maison> mais = maisonRepository.findByAdresseContains("Carthage");

		for (Maison m : mais) {
			System.out.println(m);
		}
	}

	@Test
	public void testfindByType() {
		List<Maison> mais = maisonRepository.findByType("Carthage", "villa");
		for (Maison m : mais) {
			System.out.println(m);
		}

	}

	@Test
	public void testfindByPersonne() {
		Personne pers = new Personne();
		pers.setIdPers(1L);
		List<Maison> mais = maisonRepository.findByPersonne(pers);
		for (Maison m : mais) {
			System.out.println(m);
		}

	}

	@Test
	public void findByPersonneIdPers() {
		List<Maison> mais = maisonRepository.findByPersonneIdPers(1L);
		for (Maison m : mais) {
			System.out.println(m);
		}

	}

	@Test
	public void testfindByOrderByAdresseAsc() {
		List<Maison> mais =

				maisonRepository.findByOrderByAdresseAsc();
		for (Maison m : mais) {
			System.out.println(m);
		}

	}

	@Test
	public void testTrierMaisonsType() {
		List<Maison> mais = maisonRepository.trierMaisonsType();
		for (Maison m : mais) {
			System.out.println(m);
		}

	}

}
