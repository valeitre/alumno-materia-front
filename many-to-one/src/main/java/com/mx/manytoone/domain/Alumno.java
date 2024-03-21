package com.mx.manytoone.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ALUMNO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ALUMNO")
	private Long idAlumno;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "EDAD")
	private int edad;

	@Column(name = "CARRERA")
	private int carrera;

	@ManyToOne
	@JoinColumn(name = "MATERIA_ID")
	private Materia materia;

}
