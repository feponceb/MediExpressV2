package com.example.Factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Factura.model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long>
{

}
