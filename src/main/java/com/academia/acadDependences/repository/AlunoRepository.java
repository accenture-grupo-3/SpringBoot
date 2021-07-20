package com.academia.acadDependences.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.acadDependences.model.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno, Integer> {

	
}
