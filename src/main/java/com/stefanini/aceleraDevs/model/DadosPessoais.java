package com.stefanini.aceleraDevs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class DadosPessoais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CPF
	private String cpf;

	@Email
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private String rg;

	@Column(nullable = false)
    private String rua;
	
    @Column(nullable = false)
    private String numero;
    
    @Column(nullable = false)
    private String cidade;
    
    @Column(nullable = false)
    private String estado;
    
    @Column(nullable = false)
    private String cep;

	public DadosPessoais() {

	}

	public DadosPessoais(Long id, @CPF String cpf, @Email String email, String telefone, String rg, String rua, String numero, String cidade, String estado, String cep) {
		this.id = id;
		this.cpf = cpf;
		this.email = email;
		this.rg = rg;
		this.telefone = telefone;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;

	}


	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}