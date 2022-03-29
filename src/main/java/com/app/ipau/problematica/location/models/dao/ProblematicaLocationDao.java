package com.app.ipau.problematica.location.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.ipau.problematicalocation.models.entities.ProblematicaLocation;


public interface ProblematicaLocationDao extends CrudRepository<ProblematicaLocation, Long> {
	
	public List<ProblematicaLocation> findByProblematica3_idProblematica3(int idProblematica3);
	
	public ProblematicaLocation findByLatitudAndLongitud(Double latidud, Double longitud);
	
	@Query("select pl from ProblematicaLocation pl where pl.problematica3.esPrivada = ?1 and pl.problematica3.idProblematica3 = ?2")
	public List<ProblematicaLocation> findProbLocationPerPrivacy(boolean isPrivate, int idProblematica3);

}
