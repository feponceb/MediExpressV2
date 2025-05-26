package com.mediexpress.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.productos.model.Categoria;
import com.mediexpress.productos.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Traer todas las categorias
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }
    // Buscar categoria por id
    public Categoria getCategoria(Long id) {
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    // Crear categoria
    public Categoria saveCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Eliminar categoria

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Actualizar categoria
    public Categoria updateCategoria(Long id, Categoria categoria) {
        Categoria categoriaExistente = getCategoria(id);
        categoriaExistente.setNombre(categoria.getNombre());
        return categoriaRepository.save(categoriaExistente);
    }

}
