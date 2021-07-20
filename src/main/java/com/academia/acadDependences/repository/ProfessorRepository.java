package com.academia.acadDependences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.acadDependences.model.Aluno;
import com.academia.acadDependences.model.Professor;

public interface ProfessorRepository extends JpaRepository <Professor, Integer> {

}
