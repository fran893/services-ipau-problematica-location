package com.app.ipau.problematica.location.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.ipau.commons.problematica.location.models.entities.ProblematicaLocation;

public interface ProblematicaLocationDao extends CrudRepository<ProblematicaLocation, Long> {
	
	public List<ProblematicaLocation> findByProblematica3_idProblematica3(int idProblematica3);
	
	public ProblematicaLocation findByLatitudAndLongitud(Double latidud, Double longitud);

}
