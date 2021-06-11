package com.Aziz.maison.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPers;
	private String nomPers;
	@JsonIgnore
	@OneToMany(mappedBy = "personne")
	private List<Maison> maisons;

	public Personne() {
	}

	public Personne(String nomPers, List<Maison> maisons) {

		super();
		this.nomPers = nomPers;
		this.maisons = maisons;
	}

	public Long getIdPers() {
		return idPers;
	}

	public void setIdPers(Long idPers) {
		this.idPers = idPers;
	}

	public String getNomPers() {
		return nomPers;
	}

	public void setNomPers(String nomPers) {
		this.nomPers = nomPers;
	}

	public List<Maison> getMaisons() {
		return maisons;
	}

	public void setMaisons(List<Maison> maisons) {
		this.maisons = maisons;
	}

	@Override
	public String toString() {
		return "Personne [idPers=" + idPers + ", nomPers=" + nomPers + "]";
	}
	
}