package com.mx.manytoone.service;

import com.mx.manytoone.dao.AlumnoRepository;
import com.mx.manytoone.domain.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
    private AlumnoRepository alumnoRepository;


    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno getAlumnoById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno updateAlumno(Long id, Alumno alumno) {
        Optional<Alumno> existingAlumnoOptional = alumnoRepository.findById(id);
        if (existingAlumnoOptional.isPresent()) {
            Alumno existingAlumno = existingAlumnoOptional.get();
            existingAlumno.setNombre(alumno.getNombre());
            existingAlumno.setApellidos(alumno.getApellidos());
            existingAlumno.setEdad(alumno.getEdad());
            existingAlumno.setCarrera(alumno.getCarrera());
            existingAlumno.setMateria(alumno.getMateria());
            return alumnoRepository.save(existingAlumno);
        }
        return null;
    }

    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
}

