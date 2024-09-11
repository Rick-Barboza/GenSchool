package com.gen_school_api.degen_school_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gen_school_api.degen_school_api.entity.Participante;
import com.gen_school_api.degen_school_api.repository.ParticipanteRepository;

@Service
public class ParticipanteService {
	
	@Autowired // Estamos injetando o repository no controller através da anotação,
	private ParticipanteRepository repository;
	
	public Participante findById (long id) {
		Optional<Participante> participante = repository.findById(id);   //O objeto optional ele aceita valores nulos e nos fornece varios metodos para admnistrar isto e nao gerar um erro null point exception
		
		if(id <= 0 ) //Para casos de tentativas de id menor ou igual a zero.
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O id nao pode ser menor ou igual a zero");
		
		if(participante.isEmpty()) //se nao exister devolva um erro com status http 404
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Participante ou Id inexistente");
		else
			return participante.get();
		
	}
	
	
	public Participante saveParticipante(Participante participante) {
		participante.setMediaFinal(
				calcMedia(participante.getNotaPriSemetres(), participante.getNotaSegSemetres()));	
		return repository.save(participante);
		
	}
	
	private double calcMedia(double priValue, double secValue) {
		return (priValue + secValue )/2;
	}

}
