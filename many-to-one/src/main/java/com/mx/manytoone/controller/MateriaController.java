package com.mx.manytoone.controller;

import com.mx.manytoone.domain.Materia;
import com.mx.manytoone.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/materias")
@CrossOrigin("*")
public class MateriaController {

	@Autowired
    private  MateriaService materiaService;


    @GetMapping
    public ResponseEntity<List<Materia>> getAllMaterias() {
        List<Materia> materias = materiaService.getAllMaterias();
        return new ResponseEntity<>(materias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable Long id) {
        Materia materia = materiaService.getMateriaById(id);
        if (materia != null) {
            return new ResponseEntity<>(materia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Materia> saveMateria(@RequestBody Materia materia) {
        Materia savedMateria = materiaService.saveMateria(materia);
        return new ResponseEntity<>(savedMateria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable Long id, @RequestBody Materia materia) {
        Materia updatedMateria = materiaService.updateMateria(id, materia);
        if (updatedMateria != null) {
            return new ResponseEntity<>(updatedMateria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable Long id) {
        materiaService.deleteMateria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
