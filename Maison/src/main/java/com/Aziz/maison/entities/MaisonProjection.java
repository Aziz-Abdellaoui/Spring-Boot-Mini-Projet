package com.Aziz.maison.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "adresse", types = { Maison.class })
public interface MaisonProjection {
	public String getAdresse();
}