package com.academia.acadDependences.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

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
@GroupSequence({Professor.class})
public class Professor {
	
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	private int id;
	@NotBlank(message = "O campo name é obrigatorio")
	private String name;
	@Length(min = 11, max = 11 , message = "o cpf devera ter exatemente 11 caracteres")
	//@NotBlank(message = "O campo cpf é obrigatorio")
	private String cpf;
	@Min(18)
	@NotEmpty(message = "O campo idade é obrigatorio" , groups = Professor.class)
	private int idade;
	@Min(1100)
	@NotEmpty(message = "O campo salario é obrigatorio" , groups = Professor.class)
	private double salario;

}
