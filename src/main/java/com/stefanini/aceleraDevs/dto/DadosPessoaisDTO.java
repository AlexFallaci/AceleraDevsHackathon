package com.stefanini.aceleraDevs.dto;

import org.hibernate.validator.constraints.br.CPF;

public class DadosPessoaisDTO {


    @CPF
    private String cpf;

    private String email;
    
    private String telefone;

    private String rg;

    private Long idTurma;

    private Long idCurso;

    private String rua;
	
    private String numero;
        
    private String cidade;
    
    private String estado;
    
    private String cep;

    public DadosPessoaisDTO() {
    }

    public DadosPessoaisDTO(@CPF String cpf, String email, String telefone, String rg, Long idTurma, Long idCurso,
			String rua, String numero, String cidade, String estado, String cep) {
		super();
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.rg = rg;
		this.idTurma = idTurma;
		this.idCurso = idCurso;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
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

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
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
