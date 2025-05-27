package com.mediexpress.inventario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.inventario.model.Inventario;
import com.mediexpress.inventario.repository.InventarioRepository;

@Service
public class InventarioService {
    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventario(Long id) {
        return inventarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
    }
    public Inventario saveInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    public void deleteInventario(Long id) {
        inventarioRepository.deleteById(id);
    }

    public Inventario updateInventario(Long id, Inventario inventario) {
        Inventario inventarioExistente = getInventario(id);
        inventarioExistente.setIdProducto(inventario.getIdProducto());
        inventarioExistente.setStock(inventario.getStock());
        inventarioExistente.setPrecio(inventario.getPrecio());
        inventarioExistente.setFechaExp(inventario.getFechaExp());
        return inventarioRepository.save(inventarioExistente);
    }
}
