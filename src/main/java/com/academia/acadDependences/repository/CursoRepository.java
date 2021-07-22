package com.academia.acadDependences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.acadDependences.model.Aluno;
import com.academia.acadDependences.model.Curso;

public interface CursoRepository extends JpaRepository <Curso, Integer> {

}
