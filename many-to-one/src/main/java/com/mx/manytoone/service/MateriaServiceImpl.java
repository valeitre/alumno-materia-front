package com.mx.manytoone.service;

import com.mx.manytoone.dao.MateriaRepository;
import com.mx.manytoone.domain.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    @Autowired
    public MateriaServiceImpl(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Override
    public List<Materia> getAllMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public Materia getMateriaById(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    @Override
    public Materia saveMateria(Materia materia) {
        return materiaRepository.save(materia);
    }

    @Override
    public Materia updateMateria(Long id, Materia materia) {
        Optional<Materia> existingMateriaOptional = materiaRepository.findById(id);
        if (existingMateriaOptional.isPresent()) {
            Materia existingMateria = existingMateriaOptional.get();
            existingMateria.setNombre(materia.getNombre());
            existingMateria.setNivel(materia.getNivel());
            existingMateria.setCreditos(materia.getCreditos());
            existingMateria.setDocente(materia.getDocente());
            return materiaRepository.save(existingMateria);
        }
        return null;
    }

    @Override
    public void deleteMateria(Long id) {
        materiaRepository.deleteById(id);
    }
}
