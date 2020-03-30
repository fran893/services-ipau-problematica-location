package com.app.ipau.problematica.location.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.app.ipau.problematica.location.models.services.IProblematicaLocation;
import com.app.ipau.problematicalocation.models.entities.ProblematicaLocation;

@RestController
public class ProblematicaLocationController {
	
	@Autowired
	private Environment env;

	@Autowired
	private IProblematicaLocation probLocationServices;
	
	@GetMapping("/problematicasLocation")
	public List<ProblematicaLocation> listar(){
		return probLocationServices.findAll();
	}
	
	@GetMapping("/problematicasLocationPerPrivacy/{isPrivacy}/{idProb3}")
	public List<ProblematicaLocation> listarPorPrivacidad(@PathVariable boolean isPrivacy, @PathVariable int idProb3){
		return probLocationServices.findProbLocationPerPrivacy(isPrivacy, idProb3);
	}
	
	@GetMapping("/getLocation/{latitud}/{longitud}")
	public ProblematicaLocation getLocation(@PathVariable Double latitud, @PathVariable Double longitud) {
		return probLocationServices.findByLatitudAndLongitud(latitud, longitud);
	}
	
	@GetMapping("/locationsProb3/{prob3}")
	public List<ProblematicaLocation> getLocationsByProb3(@PathVariable int prob3){
		return probLocationServices.findByIdProblematica3(prob3);
	}
	
	@PostMapping("/addProblematicaLocation")
	@ResponseStatus(HttpStatus.CREATED)
	public ProblematicaLocation saveProblematicaLocation(@RequestBody @Valid ProblematicaLocation problematicaLocaction) {
		return probLocationServices.save(problematicaLocaction);
	}
	
	@PutMapping("/updateCountMarker/{idProbLocation}")
	@ResponseStatus(HttpStatus.CREATED)
	public ProblematicaLocation updateProbLocation(@PathVariable Long idProbLocation) {
		ProblematicaLocation problematicaLocationDb = probLocationServices.findById(idProbLocation);
		problematicaLocationDb.setCantVecesMarcada(problematicaLocationDb.getCantVecesMarcada() + 1);
		return probLocationServices.save(problematicaLocationDb);
	}
	
	@GetMapping("/pruebaProfile")
	public String getVariableProfile() {
		return env.getProperty("eureka.client.service-url.defaultZone");
	}
	
}
