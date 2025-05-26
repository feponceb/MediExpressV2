package com.example.Factura.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Factura")
@AllArgsConstructor
@NoArgsConstructor
public class Factura
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;

    @Column(nullable = false)
    private Long id_cli;

    @OneToMany(mappedBy = "Factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalle;
    /*
    OTM → Uno a muchos
    mappedBy → el nombre del campo de la entidad DetalleFactura
    cascade → Cuando se guarda la factura, tambien se actualiza el detalle
    orphanRemoval → Si se borra un detalle de la lista, se elimina de la base de datos
    */

    private Double Total;
}