package com.example.Factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Factura.model.DetalleFactura;
import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleFactura, Long>
{
    List<DetalleFactura> findByFactura_IdFactura(Long idFactura);
    List<DetalleFactura> findByIdProducto(Long idProducto);
}
//Este Repository es meramente por si queremos consultar el detalle por idProducto o el idFactura