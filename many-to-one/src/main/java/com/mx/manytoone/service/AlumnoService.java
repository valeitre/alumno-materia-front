package com.mx.manytoone.service;

import com.mx.manytoone.domain.Alumno;

import java.util.List;

public interface AlumnoService {
	List<Alumno> getAllAlumnos();

	Alumno getAlumnoById(Long id);

	Alumno saveAlumno(Alumno alumno);

	Alumno updateAlumno(Long id, Alumno alumno);

	void deleteAlumno(Long id);
}
