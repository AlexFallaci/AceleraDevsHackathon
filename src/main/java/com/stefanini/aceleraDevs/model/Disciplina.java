package com.stefanini.aceleraDevs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String conteudoProgramatico;

    @Column(nullable = false)
    private Integer numeroCreditos = 0;

    private Integer totalHoras;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Disciplina(Long id, String nome, String codigo, String conteudoProgramatico, Integer numeroCreditos, Integer totalHoras, Turma turma, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.conteudoProgramatico = conteudoProgramatico;
        this.numeroCreditos = numeroCreditos;
        this.totalHoras = totalHoras;
        this.turma = turma;
        this.curso = curso;
    }

	public Disciplina() {
	
	}

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getConteudoProgramatico() {
		return conteudoProgramatico;
	}

	public void setConteudoProgramatico(String conteudoProgramatico) {
		this.conteudoProgramatico = conteudoProgramatico;
	}

	public Integer getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(Integer numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public Integer getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Integer totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
    
    
}
