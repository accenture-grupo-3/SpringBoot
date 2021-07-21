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

import com.academia.acadDependences.model.Aluno;
import com.academia.acadDependences.model.Professor;
import com.academia.acadDependences.model.Professor;
import com.academia.acadDependences.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")

public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	private List<Professor> Professors = new ArrayList<Professor>();

	ProfessorController(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;
	}

	@GetMapping("/MostrarLista")
	public List<Professor> viewProfessors() {
		return this.professorRepository.findAll();
	}

	@GetMapping("/procurarProfessor/{id}")
	public Optional<Professor> viewProfessor(@PathVariable("id") int id) {
		return this.professorRepository.findById(id);
	}

	@PutMapping("/atualizar/{id}")
	public void atualizarProfessor(@PathVariable("id") int id, @RequestBody Professor newProfessor) {
		Optional<Professor> ProfessorFind = this.professorRepository.findById(id);
		if (ProfessorFind.isPresent()) {

			Professor professor = ProfessorFind.get();
			professor.setName(newProfessor.getName());
			professor.setCpf(newProfessor.getCpf());
			professor.setIdade(newProfessor.getIdade());
			professor.setSalario(newProfessor.getSalario());
			professorRepository.save(professor);
			System.out.println("Professor atualizado com sucesso!");
		} else {
			System.out.println("Professor nao encontrado!");
		}

	}

	@PostMapping("/create")
	public void criarProfessor(@Valid @RequestBody Professor professor) {
		professorRepository.save(professor);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteprofessor(@PathVariable("id") int id) {
		Optional<Professor> professorFind = this.professorRepository.findById(id);
		if (professorFind.isPresent()) {
			professorRepository.deleteById(id);
			return ("Professor Deletado com sucesso");
		} else {
			return ("Professor Nao Encontrado");
		}

	}
}
