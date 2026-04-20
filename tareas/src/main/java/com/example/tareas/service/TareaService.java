package com.example.tareas.service;

import com.example.tareas.domain.TareaNotFoundException;
import com.example.tareas.domain.model.EstadoTarea;
import com.example.tareas.domain.model.Tarea;
import com.example.tareas.repository.TareaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TareaService {

    private final TareaRepository repo;

    public TareaService(TareaRepository repo) {
        this.repo = repo;
    }

    public List<Tarea> listar() {
        return repo.findAll();
    }

    public Tarea buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new TareaNotFoundException("Tarea con id " + id + " no encontrada"));
    }

    public Tarea crear(Tarea tarea) {
        tarea.setEstado(EstadoTarea.PENDIENTE);
        return repo.save(tarea);
    }

    public Tarea cambiarEstado(Long id, EstadoTarea estado) {
        Tarea tarea = buscar(id);
        tarea.setEstado(estado);
        return repo.save(tarea);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new TareaNotFoundException("Tarea con id " + id + " no encontrada");
        }
        repo.deleteById(id);
    }
}