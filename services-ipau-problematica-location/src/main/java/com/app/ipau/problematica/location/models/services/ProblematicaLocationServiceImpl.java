package com.app.ipau.problematica.location.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.ipau.problematica.location.models.dao.ProblematicaLocationDao;
import com.app.ipau.problematicalocation.models.entities.ProblematicaLocation;

@Service
public class ProblematicaLocationServiceImpl implements IProblematicaLocation {
	
	@Autowired
	private ProblematicaLocationDao problematicaLocationDao;

	@Override
	@Transactional(readOnly = true)
	public List<ProblematicaLocation> findAll() {
		return (List<ProblematicaLocation>) problematicaLocationDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public ProblematicaLocation findById(Long id) {
		return problematicaLocationDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProblematicaLocation> findByIdProblematica3(int idProblematica3) {
		return problematicaLocationDao.findByProblematica3_idProblematica3(idProblematica3);
	}

	@Override
	@Transactional(readOnly = true)
	public ProblematicaLocation findByLatitudAndLongitud(Double latidud, Double longitud) {
		return problematicaLocationDao.findByLatitudAndLongitud(latidud, longitud);
	}

	@Override
	@Transactional
	public ProblematicaLocation save(ProblematicaLocation problematicaLocation) {
		return problematicaLocationDao.save(problematicaLocation);
	}

	@Override
	public List<ProblematicaLocation> findProbLocationPerPrivacy(boolean isPrivate, int idProblematica3) {
		return problematicaLocationDao.findProbLocationPerPrivacy(isPrivate, idProblematica3);
	}
}
