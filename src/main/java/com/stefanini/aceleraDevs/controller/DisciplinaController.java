package com.stefanini.aceleraDevs.controller;

import com.stefanini.aceleraDevs.dto.DisciplinaDTO;
import com.stefanini.aceleraDevs.exception.CursoNotFoundException;
import com.stefanini.aceleraDevs.exception.TurmaNotFoundException;
import com.stefanini.aceleraDevs.mapper.DisciplinaDTOService;
import com.stefanini.aceleraDevs.model.Curso;
import com.stefanini.aceleraDevs.model.Disciplina;
import com.stefanini.aceleraDevs.service.CursoService;
import com.stefanini.aceleraDevs.service.DisciplinaService;
import com.stefanini.aceleraDevs.service.TurmaService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class DisciplinaController {

    private final DisciplinaService disciplinaService;
    private final DisciplinaDTOService disciplinaDTOService;
	private final CursoService cursoService;


    @Autowired
	public DisciplinaController(DisciplinaService disciplinaService, DisciplinaDTOService disciplinaDTOService,
			CursoService cursoService) {
		this.disciplinaService = disciplinaService;
		this.disciplinaDTOService = disciplinaDTOService;
		this.cursoService = cursoService;

	}


    @RequestMapping(path = "/disciplina")
    public ModelAndView loadHtml() {

        ModelAndView mv = new ModelAndView("disciplina");
        DisciplinaDTO disciplinaDTO = new DisciplinaDTO();

        mv.addObject("disciplinaDTO", disciplinaDTO);

        return mv;
    }

    
    @PostMapping(value = "/disciplina")
    public String saveDisciplina(DisciplinaDTO disciplina) throws TurmaNotFoundException, CursoNotFoundException {

        Disciplina newDisciplina = disciplinaDTOService.mapDisciplina(disciplina);

        Disciplina disciplinaSaved = disciplinaService.save(newDisciplina);
        
        Curso curso = disciplinaSaved.getCurso();
        Integer totalHorasCurso = disciplinaService.somaTotalHorasByCurso(curso);
		cursoService.atualizaTotalHoras(totalHorasCurso, curso);

		
        return "redirect:/disciplina";
    }

}
