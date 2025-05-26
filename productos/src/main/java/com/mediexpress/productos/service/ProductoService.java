package com.mediexpress.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediexpress.productos.model.Producto;
import com.mediexpress.productos.repository.ProductoRepository;


@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    // Traer todos los productos
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }
    // Buscar producto por id
    public Producto getProducto(Long id) {
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
    // Crear producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Eliminar producto
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
    // Actualizar producto
    public Producto updateProducto(Long id, Producto producto) {
        Producto productoExistente = getProducto(id);
        productoExistente.setNombre(producto.getNombre());
        return productoRepository.save(productoExistente);
    }
}
