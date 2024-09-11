package com.gen_school_api.degen_school_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gen_school_api.degen_school_api.entity.Participante;
import com.gen_school_api.degen_school_api.repository.ParticipanteRepository;
import com.gen_school_api.degen_school_api.service.ParticipanteService;

@RestController //Define esta class como uma class controladora rest
@RequestMapping("/participante") //Define o caminho para acessar o controller
@CrossOrigin(value = "*") //habilita requisições de origens diferentes
public class ParticipanteController {
	
	@Autowired // Estamos injetando o repository no controller através da anotação,
	private ParticipanteRepository repository;
	
	
	@Autowired // Estamos injetando o repository no controller através da anotação,
	private ParticipanteService service;
	
	
	@GetMapping
	public ResponseEntity<List<Participante>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Participante> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/by-name/{nome}")
	public ResponseEntity<List<Participante>> findByName(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Participante> post(@RequestBody Participante participante){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.saveParticipante(participante));
	}
	
	@PutMapping
	public ResponseEntity<Participante> put(@RequestBody Participante participante){
		service.findById(participante.getId());
		return ResponseEntity.ok(repository.save(participante));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.findById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	

}
