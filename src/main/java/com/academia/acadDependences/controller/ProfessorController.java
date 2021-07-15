package com.academia.acadDependences.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.acadDependences.model.Professor;

@RestController
@RequestMapping("/professor")

public class ProfessorController {

	private List<Professor> professores = new ArrayList<Professor>();

	@GetMapping("/MostrarLista")
	public List<Professor> viewProfessors() {
		return professores;
	}

	@GetMapping("/procurarProfessor/{id}")
	public Professor viewProfessor(@PathVariable("id") int id) {
		Professor professor = null;
		for (Professor al : professores) {
			if (al.getId() == id)
				professor = al;
		}
		return professor;
	}

	@PutMapping("/atualizar/{id}")
	public List<Professor> atualizarProfessor(@PathVariable("id") int id, @RequestBody Professor professor) {
		Professor al = null;
		for (int i = 0;i<professores.size();i++ ) {
			al = professores.get(i);
			if (al.getId() == id) {
			professores.set(i, professor);
				//al = professor;
			}
		}
		return professores;
	}

	@PostMapping("/create")
	public void criarProfessor(@RequestBody Professor professor) {
		professores.add(professor);

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		Professor a = null;
		boolean encontrou = false;
		for (Professor al : professores) {
			if (al.getId() == id) {
				encontrou = true;
				a = al;
			}
		}
		if (encontrou == true) {
			professores.remove(a);
		}

	}

}
