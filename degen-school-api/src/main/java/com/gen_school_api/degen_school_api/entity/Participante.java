package com.gen_school_api.degen_school_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_participante")
public class Participante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Insira um nome valido, nao é permitido valores brancos ou nulo")
	private String nome;	
	
	@Min(value = 18, message = "Só será permitido alunos maiores de 18 anos de idade")
	private Integer idade;
	
	@Min(value = 0, message = "Nota minima permitida é zero")
	@Max(value = 10, message = "Nota maxima permitida é dez")
	private double notaPriSemetres;
	
	@Min(value = 0, message = "Nota minima permitida é zero")
	@Max(value = 10, message = "Nota maxima permitida é dez")
	private double notaSegSemetres;
	
	private double mediaFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public double getNotaPriSemetres() {
		return notaPriSemetres;
	}

	public void setNotaPriSemetres(double notaPriSemetres) {
		this.notaPriSemetres = notaPriSemetres;
	}

	public double getNotaSegSemetres() {
		return notaSegSemetres;
	}

	public void setNotaSegSemetres(double notaSegSemetres) {
		this.notaSegSemetres = notaSegSemetres;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	
}
