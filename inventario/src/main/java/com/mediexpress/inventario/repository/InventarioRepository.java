package com.mediexpress.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.inventario.model.Inventario;

@Repository
public interface InventarioRepository  extends JpaRepository<Inventario, Long> {

}
