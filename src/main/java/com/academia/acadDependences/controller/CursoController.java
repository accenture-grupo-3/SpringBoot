package com.academia.acadDependences.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.acadDependences.model.Curso;
import com.academia.acadDependences.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	private List<Curso> Cursos = new ArrayList<Curso>();

	CursoController(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}

	@GetMapping("/MostrarLista")
	public List<Curso> viewCursos() {
		return this.cursoRepository.findAll();
	}

	@GetMapping("/procurarCurso/{id}")
	public Optional<Curso> viewCurso(@PathVariable("id") int id) {
		return this.cursoRepository.findById(id);
	}

	@PutMapping("/atualizar/{id}")
	public void atualizarCurso(@PathVariable("id") int id, @RequestBody Curso newCurso) {
		Optional<Curso> CursoFind = this.cursoRepository.findById(id);
		if (CursoFind.isPresent()) {

			Curso curso = CursoFind.get();
			curso.setName(newCurso.getName());
			cursoRepository.save(curso);
			System.out.println("Curso atualizado com sucesso!");
		} else {
			System.out.println("Curso nao encontrado!");
		}

	}

	@PostMapping("/create")
	public void criarCurso(@Valid @RequestBody Curso curso) {
		cursoRepository.save(curso);

	}

	@DeleteMapping("/delete/{id}")
	public String deletecurso(@PathVariable("id") int id) {
		Optional<Curso> cursoFind = this.cursoRepository.findById(id);
		if (cursoFind.isPresent()) {
			cursoRepository.deleteById(id);
			return ("Curso Deletado com sucesso");
		} else {
			return ("Curso Nao Encontrado");
		}

	}
}