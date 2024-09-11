package com.gen_school_api.degen_school_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gen_school_api.degen_school_api.entity.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long>{
	 public List<Participante> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
