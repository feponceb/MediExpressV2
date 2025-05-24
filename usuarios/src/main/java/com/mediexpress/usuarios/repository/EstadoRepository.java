package com.mediexpress.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mediexpress.usuarios.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
