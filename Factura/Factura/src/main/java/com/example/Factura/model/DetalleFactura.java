<<<<<<< HEAD
package com.example.Factura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Detalle_Factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFactura
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @Column(nullable = false)
    private Long idProducto;

    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
=======
package com.example.Factura.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Detalle_Factura")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFactura
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_factura", nullable = false)
    private Factura factura;

    @Column(nullable = false)
    private Long idProducto;

    private Integer cantidad;
    private Double precioUnitario;
    private Double subtotal;
>>>>>>> edbea5e53aa304fa47d9ca6233926cfa525985de
}