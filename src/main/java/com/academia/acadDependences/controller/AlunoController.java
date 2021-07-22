package com.academia.acadDependences.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

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
import com.academia.acadDependences.model.Curso;
import com.academia.acadDependences.model.Professor;
import com.academia.acadDependences.repository.AlunoRepository;
import com.academia.acadDependences.repository.CursoRepository;

@RestController
@RequestMapping("/aluno")

public class AlunoController {
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private AlunoRepository alunoRepository;
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	AlunoController(AlunoRepository alunonRepository) {
        this.alunoRepository = alunoRepository;
    }

	@GetMapping("/MostrarLista")
	public List<Aluno> viewAlunos() {
		return this.alunoRepository.findAll();
	}

	@GetMapping("/procurarAluno/{id}")
	public Optional<Aluno> viewAluno(@PathVariable("id") int id) {
		return  this.alunoRepository.findById(id);
		}


	@PutMapping("/atualizar/{id}")
	public String atualizarAluno(@PathVariable("id") int id, @RequestBody Aluno newaluno) {
		Optional<Aluno> alunoFind = this.alunoRepository.findById(id);
		if (alunoFind.isPresent()) {
			
			
			Aluno aluno = alunoFind.get();
			aluno.setName(newaluno.getName());
			aluno.setCpf(newaluno.getCpf());
            aluno.setIdade(newaluno.getIdade());
            aluno.setCurso(newaluno.getCurso());
            alunoRepository.save(aluno);
            return ("Aluno atualizado com sucesso!");
		} else {
			return ("Aluno nao encontrado!");
		}
		
	}

	@PostMapping("/create")
	void criarAluno(@Valid @RequestBody Aluno aluno) {
		
		/*Optional<Curso> cursoFind = this.cursoRepository.findById(id);
		if (cursoFind.isPresent()) {
			aluno.setCurso(cursoFind.get());
		}*/
		alunoRepository.save(aluno);


	}

	@DeleteMapping("/delete/{id}")
	public String deletealuno(@PathVariable("id") int id) {
		Optional<Aluno> alunoFind = this.alunoRepository.findById(id);
		if (alunoFind.isPresent()) {
		alunoRepository.deleteById(id);	
		return ("Aluno Deletado com sucesso");
		} else { 
			return ("Aluno Nao Encontrado");
		}
	}
}