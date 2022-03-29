package com.app.ipau.problematica.location.models.services;

import java.util.List;

import com.app.ipau.problematicalocation.models.entities.ProblematicaLocation;


public interface IProblematicaLocation {

	public List<ProblematicaLocation> findAll();
	
	public ProblematicaLocation findById(Long id);
	
	public List<ProblematicaLocation> findByIdProblematica3(int idProblematica3);
	
	public ProblematicaLocation findByLatitudAndLongitud(Double latidud, Double longitud);
	
	public ProblematicaLocation save(ProblematicaLocation problematicaLocation);
	
	public List<ProblematicaLocation> findProbLocationPerPrivacy(boolean isPrivate, int idProblematica3);
	
}
