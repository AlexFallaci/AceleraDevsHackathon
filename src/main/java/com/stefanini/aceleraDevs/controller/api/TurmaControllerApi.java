package com.stefanini.aceleraDevs.controller.api;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.stefanini.aceleraDevs.dto.DetalheTurmaDTO;
import com.stefanini.aceleraDevs.dto.TurmaDTO;
import com.stefanini.aceleraDevs.exception.CursoNotFoundException;
import com.stefanini.aceleraDevs.exception.TurmaNotFoundException;
import com.stefanini.aceleraDevs.forms.TurmaForm;
import com.stefanini.aceleraDevs.mapper.TurmaDTOService;
import com.stefanini.aceleraDevs.model.Turma;
import com.stefanini.aceleraDevs.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaControllerApi {

	private final TurmaService turmaService;
	private final TurmaDTOService turmaDTOService;

	@Autowired
	public TurmaControllerApi(TurmaService turmaService, TurmaDTOService turmaDTOService) {
		this.turmaService = turmaService;
		this.turmaDTOService = turmaDTOService;
	}

	@GetMapping
	public ResponseEntity<List<TurmaDTO>> listaTurma() {
		List<Turma> turmas = turmaService.findAllTurmas();
		return ResponseEntity.ok(TurmaDTO.converter(turmas));
	}

	@PostMapping()
	public ResponseEntity<TurmaDTO> createTurma(@RequestBody @Valid TurmaDTO turma, UriComponentsBuilder uriBuilder)
			throws TurmaNotFoundException, CursoNotFoundException {
		Turma newTurma = turmaDTOService.mapTurma(turma);
		Turma turmaSaved = turmaService.save(newTurma);
		URI uri = uriBuilder.path("/api/turma/{id}").buildAndExpand(turmaSaved.getId()).toUri();
		return ResponseEntity.created(uri).body(new TurmaDTO(turmaSaved));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalheTurmaDTO> readTurma(@PathVariable Long id) {
		try {
			Turma turma = turmaService.findById(id);
			return ResponseEntity.ok(new DetalheTurmaDTO(turma));

		} catch (TurmaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<TurmaDTO> updateTurma(@PathVariable Long id, @RequestBody @Valid TurmaForm turmaForm) {
		try {
			Turma turmaUpdated = turmaForm.atualizar(id, turmaService);
			return ResponseEntity.ok(new TurmaDTO(turmaUpdated));
		} catch (TurmaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			Turma turma = turmaService.findById(id);
			turmaService.deleteById(turma.getId());
			return ResponseEntity.ok().build();
		}catch (TurmaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

}