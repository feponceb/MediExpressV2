package com.example.Factura.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Factura.model.DetalleFactura;
import com.example.Factura.model.Factura;
import com.example.Factura.repository.FacturaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FacturaService
{
    private final FacturaRepository facturaRepository; //final pq asi no se modifica por error y leí que es más moderno lol

    public Factura crearFactura(Factura factura)
    {
        double total = 0;
        for(DetalleFactura detalle : factura.getDetalle())
        {
            detalle.setFactura(factura);
            double subtotal = detalle.getCantidad() * detalle.getPrecioUnitario();
            detalle.setSubtotal(subtotal); //Se declara el subtotal
            total += subtotal; //Se le suma al total, recuerden que esto lo hace por cada objeto en el detalle
        }
        factura.setTotal(total);
        return facturaRepository.save(factura);
    }

    public List<Factura> listarFacturas()
    {
        return facturaRepository.findAll();
    }
}
