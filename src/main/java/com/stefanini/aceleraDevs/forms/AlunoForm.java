package com.stefanini.aceleraDevs.forms;

import javax.validation.constraints.NotNull;

import com.stefanini.aceleraDevs.exception.AlunoNotFoundException;
import com.stefanini.aceleraDevs.exception.TurmaNotFoundException;
import com.stefanini.aceleraDevs.model.Aluno;
import com.stefanini.aceleraDevs.model.DadosPessoais;
import com.stefanini.aceleraDevs.model.Turma;
import com.stefanini.aceleraDevs.service.AlunoService;
import com.stefanini.aceleraDevs.service.TurmaService;

public class AlunoForm {
	@NotNull
    private String nome;
	@NotNull
    private String matricula;
	@NotNull
    private String cpf;
	@NotNull
    private String email;
	@NotNull
	private String telefone;
	@NotNull
	private String rg;
	@NotNull
    private Long idTurma;
	@NotNull
    private String rua;	
	@NotNull
    private String numero;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String cep;
	
	
	public String getNome() {
		return nome;
	}


	public String getMatricula() {
		return matricula;
	}


	public String getCpf() {
		return cpf;
	}


	public String getEmail() {
		return email;
	}


	public String getTelefone() {
		return telefone;
	}


	public String getRg() {
		return rg;
	}


	public Long getIdTurma() {
		return idTurma;
	}


	public String getRua() {
		return rua;
	}


	public String getNumero() {
		return numero;
	}


	public String getCidade() {
		return cidade;
	}


	public String getEstado() {
		return estado;
	}


	public String getCep() {
		return cep;
	}


	public Aluno atualizar(Long id, AlunoService alunoService, TurmaService turmaService) throws AlunoNotFoundException, TurmaNotFoundException {
		Aluno aluno = alunoService.findById(id);
		DadosPessoais dadosPessoais = aluno.getDadosPessoais();
		Turma turma = turmaService.findById(idTurma);
		aluno.setNome(this.nome);
		dadosPessoais.setCpf(this.cpf);
		dadosPessoais.setEmail(this.email);
		dadosPessoais.setRg(rg);
		dadosPessoais.setTelefone(telefone);
		dadosPessoais.setRua(rua);
		dadosPessoais.setNumero(numero);
		dadosPessoais.setCidade(cidade);
		dadosPessoais.setEstado(estado);
		dadosPessoais.setCep(cep);
		aluno.setDadosPessoais(dadosPessoais);
		aluno.setMatricula(this.matricula);
		aluno.setTurma(turma);
		alunoService.save(aluno);
		return aluno;
	}
	
	
}