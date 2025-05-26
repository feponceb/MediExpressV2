package com.mediexpress.productos.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediexpress.productos.model.Producto;
import com.mediexpress.productos.service.ProductoService;


import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    //endpoint para obtener todos los productos
    
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos(){
        List<Producto> productos = productoService.getProductos();
        if(productos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    //endpoint para obtener un producto por su id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id){
        try {
            Producto producto = productoService.getProducto(id);
            return ResponseEntity.ok(producto);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    // endpoint para agregar un producto
    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto nuevo){
        return ResponseEntity.status(201).body(productoService.saveProducto(nuevo));
    }
    // endpoint para eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }
}
