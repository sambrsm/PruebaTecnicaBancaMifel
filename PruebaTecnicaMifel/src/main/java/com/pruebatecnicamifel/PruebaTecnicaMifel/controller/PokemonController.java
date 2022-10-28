package com.pruebatecnicamifel.PruebaTecnicaMifel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("pokemon")
public class PokemonController {

	@GetMapping("/{nombre}")
	public ResponseEntity<String> getPokemon(@PathVariable("nombre") String nombre) {
		RestTemplate restTemplate = new RestTemplate();
		StringBuffer bufferUri = new StringBuffer("https://pokeapi.co/api/v2/pokemon/");
		if (nombre == null || nombre.equals("")) {
			bufferUri.append("ditto");
		} else {
			bufferUri.append(nombre);
		}
		String resultados = restTemplate.getForObject(bufferUri.toString(), String.class);
		return new ResponseEntity<String>(resultados, HttpStatus.OK);

	}
}
