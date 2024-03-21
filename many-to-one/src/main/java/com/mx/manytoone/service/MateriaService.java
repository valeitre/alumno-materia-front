package com.mx.manytoone.service;

import com.mx.manytoone.domain.Materia;

import java.util.List;

import java.util.List;

public interface MateriaService {
	List<Materia> getAllMaterias();

	Materia getMateriaById(Long id);

	Materia saveMateria(Materia materia);

	Materia updateMateria(Long id, Materia materia);

	void deleteMateria(Long id);
}
