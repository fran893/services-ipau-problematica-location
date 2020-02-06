package com.app.ipau.problematica.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.ipau.commons.problematica.location.models.entities.ProblematicaLocation;
import com.app.ipau.problematica.location.models.services.IProblematicaLocation;

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
	
	@GetMapping("/getLocation/{latitud}/{longitud}")
	public ProblematicaLocation getLocation(@PathVariable Double latitud, @PathVariable Double longitud) {
		return probLocationServices.findByLatitudAndLongitud(latitud, longitud);
	}
	
	@GetMapping("/locationsProb3/{prob3}")
	public List<ProblematicaLocation> getLocationsByProb3(@PathVariable int prob3){
		return probLocationServices.findByIdProblematica3(prob3);
	}
	
	@PostMapping("/addProblematicaLocation")
	public ProblematicaLocation saveProblematicaLocation(@RequestBody ProblematicaLocation problematicaLocaction) {
		return probLocationServices.save(problematicaLocaction);
	}
	
	@GetMapping("/pruebaProfile")
	public String getVariableProfile() {
		return env.getProperty("eureka.client.service-url.defaultZone");
	}
	
}
