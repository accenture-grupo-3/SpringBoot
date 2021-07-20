package com.academia.acadDependences.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table
public class Professor {
	
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	private String cpf;
	private int idade;
	private double salario;

}
