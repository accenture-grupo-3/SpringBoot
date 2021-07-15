package com.academia.acadDependences.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Professor {
	
	private int id;
	private String name;
	private String cpf;
	private int idade;
	private double salario;

}
