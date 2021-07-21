package com.academia.acadDependences.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Reference;

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
@GroupSequence({Aluno.class})
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	@NotBlank(message = "O campo name é obrigatorio")
	private String name;
	//@NotBlank(message = "O campo cpf é obrigatorio" , groups = Aluno.class)
	@Length(min = 11, max = 11 , message = "Cpf tem 11 digitos" )
	private String cpf;
	@Min(18)
	private int idade;
	@NotBlank(message =  "{curso.not.blank}")
	private String curso;
}
