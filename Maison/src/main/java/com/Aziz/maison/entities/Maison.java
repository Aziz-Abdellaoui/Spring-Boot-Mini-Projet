package com.Aziz.maison.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
public class Maison {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMaison;
	@NotNull
	@Size(min = 4, max = 15)
	private String adresse;
	@NotNull
	@Size(min = 4, max = 15)
	private String type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateAchat;
	@ManyToOne
	private Personne personne;

	public Maison() {
		super();
	}

	public Maison(String adresse, String type, Date dateAchat) {
		super();
		this.adresse = adresse;
		this.type = type;
		this.dateAchat = dateAchat;
	}

	public Long getIdMaison() {
		return idMaison;
	}

	public void setIdMaison(Long idMaison) {
		this.idMaison = idMaison;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	@Override
	public String toString() {
		return "Maison [idMaison=" + idMaison + ", adresse=" + adresse + ", type=" + type + ", dateAchat=" + dateAchat
				+ "]";
	}
}