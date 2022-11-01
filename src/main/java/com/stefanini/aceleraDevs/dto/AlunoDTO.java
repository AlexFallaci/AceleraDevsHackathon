package com.stefanini.aceleraDevs.dto;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.stefanini.aceleraDevs.model.Aluno;
import com.stefanini.aceleraDevs.model.Endereco;

public class AlunoDTO {

    private Long id;

    private String nome;

    private String matricula;

    private String cpf;

    private String email;

    private String telefone;

    private String rg;

    private Long idTurma;

    private Long idCurso;

    private Endereco endereco;

    public AlunoDTO() {
    }

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.matricula = aluno.getMatricula();
        this.cpf = aluno.getDadosPessoais().getCpf();
        this.email = aluno.getDadosPessoais().getEmail();
        this.idTurma = aluno.getTurma().getId();
        this.idCurso = aluno.getCurso().getId();
        this.telefone = aluno.getDadosPessoais().getTelefone();
        this.rg = aluno.getDadosPessoais().getRg();
        this.endereco = aluno.getDadosPessoais().getEndereco();
    }

    public AlunoDTO(Long id, String nome, String matricula, String cpf, String email, String telefone, String rg,
            Endereco endereco, Long idTurma, Long idCurso) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        this.email = email;
        this.idTurma = idTurma;
        this.idCurso = idCurso;
        this.telefone = telefone;
        this.rg = rg;
        this.endereco = endereco;

    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static boolean validaPattern(String pattern, String texto) {
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(texto);

        if (m.find()) {
            return true;
        }
        return false;

    }

    public static boolean validaCep(String cep) {
        String patternCep = "^([\\d]{2})\\.?([\\d]{3})\\-?([\\d]{3})";
        if (!validaPattern(patternCep, cep) || cep.length() > 9) {
            return false;
        }
        return true;
    }

    public static boolean validaTelefone(String telefone) {
        String patternTelefone = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$";
        if (!validaPattern(patternTelefone, telefone)) {
            return false;
        }
        return true;
    }

    public static boolean validaRg(String rg) {
        String patternRg = "^[0-9]{2,3}\\.?[0-9]{2,3}\\.?[0-9]{3}\\-?[A-Za-z0-9]{1}$";
        if (!validaPattern(patternRg, rg)) {
            return false;
        }
        return true;
    }

    public static boolean validaDadosPessoais(Aluno aluno) {
        if (validaRg(aluno.getDadosPessoais().getRg()) && validaTelefone(aluno.getDadosPessoais().getTelefone())
                && validaCep(aluno.getDadosPessoais().getEndereco().getCep())) {
            return true;
        }
        return false;
    }

    public static List<AlunoDTO> converter(List<Aluno> alunos) {
        return alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
    }

    
}