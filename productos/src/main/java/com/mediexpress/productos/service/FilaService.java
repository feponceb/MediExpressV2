package com.mediexpress.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.productos.model.Fila;
import com.mediexpress.productos.repository.FilaRepository;


@Service
public class FilaService {
    @Autowired
    private FilaRepository filaRepository;

    // Traer todas las filas
    public List <Fila> getFilas() {
        return filaRepository.findAll();
    }

    // Buscar fila por id
    public Fila getFila(Long id) {
        return filaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Fila no encontrada"));
    }

    // Crear fila
    public Fila saveFila(Fila fila) {
        return filaRepository.save(fila);
    }

    // Eliminar fila
    public void deleteFila(Long id) {
        filaRepository.deleteById(id);
    }

    // Actualizar fila
    public Fila updateFila(Long id, Fila fila) {
        Fila filaExistente = getFila(id);
        filaExistente.setNombre_fila(fila.getNombre_fila());
        return filaRepository.save(filaExistente);
    }
}
