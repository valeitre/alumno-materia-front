package com.mx.manytoone.controller;

import com.mx.manytoone.domain.Alumno;
import com.mx.manytoone.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin("*")
public class AlumnoController {
	
	//http:localhost:8001/
	

	@Autowired
    private AlumnoService alumnoService;


    @GetMapping
    public ResponseEntity<List<Alumno>> getAllAlumnos() {
        List<Alumno> alumnos = alumnoService.getAllAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        Alumno alumno = alumnoService.getAlumnoById(id);
        if (alumno != null) {
            return new ResponseEntity<>(alumno, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Alumno> saveAlumno(@RequestBody Alumno alumno) {
        Alumno savedAlumno = alumnoService.saveAlumno(alumno);
        return new ResponseEntity<>(savedAlumno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Alumno updatedAlumno = alumnoService.updateAlumno(id, alumno);
        if (updatedAlumno != null) {
            return new ResponseEntity<>(updatedAlumno, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

