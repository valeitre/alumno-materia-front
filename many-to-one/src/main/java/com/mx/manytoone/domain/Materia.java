package com.mx.manytoone.domain;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MATERIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materia {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MATERIA")
	private Long idMateria;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "NIVEL")
	private int nivel;

	@Column(name = "CREDITOS")
	private int creditos;

	@Column(name = "DOCENTE")
	private int docente;

//	@OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
//	List<Alumno> lista = new ArrayList<Alumno>();


}
