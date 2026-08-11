package com.perezjorge.PruebaTecFerreteria.repository;

import com.perezjorge.PruebaTecFerreteria.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


}
