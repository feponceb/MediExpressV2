package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository extends JpaRepository<Producto,Long>{

}
