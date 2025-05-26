package com.mediexpress.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.productos.model.Fila;
import com.mediexpress.productos.service.FilaService;

@RestController
@RequestMapping("api/v1/filas")
public class FilaController {
    @Autowired
    private FilaService filaService;

    // endpoint para obtener todas las filas
    @GetMapping
    public ResponseEntity<List<Fila>> obtenerFilas() {
        List<Fila> filas = filaService.getFilas();
        if (filas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(filas);
    }

    // endpoint para obtener una fila por su id
    @GetMapping("/{id}")
    public ResponseEntity<Fila> obtenerFila(@PathVariable Long id){
        try {
            Fila fila = filaService.getFila(id);
            return ResponseEntity.ok(fila);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    // endpoint para agregar una fila
    @PostMapping
    public ResponseEntity<Fila> guardarFila(@RequestBody Fila nuevo){
        return ResponseEntity.status(201).body(filaService.saveFila(nuevo));
    }
    // endpoint para eliminar una fila
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFila(@PathVariable Long id){
        filaService.deleteFila(id);
        return ResponseEntity.noContent().build();
    }
}
