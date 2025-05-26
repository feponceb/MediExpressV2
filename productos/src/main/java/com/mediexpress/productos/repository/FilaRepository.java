package com.mediexpress.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.productos.model.Fila;

@Repository
public interface FilaRepository extends JpaRepository<Fila, Long> {
    

}
