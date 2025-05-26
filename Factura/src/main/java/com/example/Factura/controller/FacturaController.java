package com.example.Factura.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Factura.model.Factura;
import com.example.Factura.service.FacturaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/facturas")
@RequiredArgsConstructor
public class FacturaController
{
    private final FacturaService Service;

    @PostMapping
    public ResponseEntity<Factura> crearFactura(@RequestBody Factura Factura)
    {
        Factura nueva = Service.crearFactura(Factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @GetMapping
    public ResponseEntity<List<Factura>> obtenerFacturas()
    {
        return ResponseEntity.ok(Service.listarFacturas());
    }
}