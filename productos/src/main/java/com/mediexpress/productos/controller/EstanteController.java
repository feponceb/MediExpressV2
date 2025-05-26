package com.mediexpress.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.productos.model.Estante;
import com.mediexpress.productos.service.EstanteService;

@RestController
@RequestMapping("/api/v1/estantes")
public class EstanteController {
    @Autowired
    private EstanteService estanteService;

    // Endpoint para obtener todos los estantes
    @GetMapping
    public ResponseEntity<List<Estante>> obtenerEstantes() {
        List<Estante> estantes = estanteService.getEstantes();
        if (estantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estantes);
    }

    // Endpoint para obtener un estante por su id
    @GetMapping("/{id}")
    public ResponseEntity<Estante> obtenerEstante(@PathVariable Long id) {
        try {
            Estante estante = estanteService.getEstante(id);
            return ResponseEntity.ok(estante);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para agregar un estante
    @PostMapping
    public ResponseEntity<Estante> guardarEstante(@RequestBody Estante nuevo) {
        return ResponseEntity.status(201).body(estanteService.saveEstante(nuevo));
    }

    // Endpoint para eliminar un estante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstante(@PathVariable Long id) {
        estanteService.deleteEstante(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para actualizar un estante
    @PutMapping("/{id}")
    public ResponseEntity<Estante> actualizarEstante(@PathVariable Long id, @RequestBody Estante estante) {
        try {
            Estante estanteActualizado = estanteService.updateEstante(id, estante);
            return ResponseEntity.ok(estanteActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
