package com.mediexpress.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.productos.model.Estante;
import com.mediexpress.productos.repository.EstanteRepository;


@Service
public class EstanteService {
    @Autowired
    private EstanteRepository estanteRepository;

    public List<Estante> getEstantes() {
        return estanteRepository.findAll();
    }

    public Estante getEstante(Long id) {
        return estanteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estante no encontrado"));
    }

    public Estante saveEstante(Estante estante) {
        return estanteRepository.save(estante);
    }

    public void deleteEstante(Long id) {
        estanteRepository.deleteById(id);
    }

    public Estante updateEstante(Long id, Estante estante) {
        Estante estanteExistente = getEstante(id);
        estanteExistente.setNombreEstante(estante.getNombreEstante());
        return estanteRepository.save(estanteExistente);
    }


}
