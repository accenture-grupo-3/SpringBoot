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

import com.academia.acadDependences.model.Aluno;

@RestController
@RequestMapping("/aluno")

public class AlunoController {

	private List<Aluno> alunos = new ArrayList<Aluno>();

	@GetMapping("/MostrarLista")
	public List<Aluno> viewAlunos() {
		return alunos;
	}

	@GetMapping("/procurarAluno/{id}")
	public Aluno viewAluno(@PathVariable("id") int id) {
		Aluno aluno = null;
		for (Aluno al : alunos) {
			if (al.getId() == id)
				aluno = al;
		}
		return aluno;
	}

	@PutMapping("/atualizar/{id}")
	public List<Aluno> atualizarAluno(@PathVariable("id") int id, @RequestBody Aluno aluno) {
		Aluno al = null;
		for (int i = 0;i<alunos.size();i++ ) {
			al = alunos.get(i);
			if (al.getId() == id) {
			alunos.set(i, aluno);
				//al = aluno;
			}
		}
		return alunos;
	}

	@PostMapping("/create")
	public void criarAluno(@RequestBody Aluno aluno) {
		alunos.add(aluno);

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		Aluno a = null;
		boolean encontrou = false;
		for (Aluno al : alunos) {
			if (al.getId() == id) {
				encontrou = true;
				a = al;
			}
		}
		if (encontrou == true) {
			alunos.remove(a);
		}

	}

}
