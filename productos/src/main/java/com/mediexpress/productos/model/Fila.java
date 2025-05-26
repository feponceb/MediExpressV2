package com.mediexpress.productos.model;

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
@Table(name = "fila")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fila {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_fila")
    private Long id;

    @Column(nullable = false)
    private String nombre_fila;

    @ManyToOne
    @JoinColumn(name = "id_estante", nullable = false)
    private Estante estante;
    

}
