package com.perezjorge.PruebaTecFerreteria.service;

import com.perezjorge.PruebaTecFerreteria.model.Producto;

import java.util.List;

public interface ProductoService {

    // Métodos para el CRUD

    // READ
    List<Producto> traerProductos();
    Producto buscarProducto(Long codProd);

    // CREATE
    Producto crearProducto(Producto prod);

    // UPDATE
    Producto editarProducto(Long codProd, Producto prod);

    // DELETE
    boolean eliminarProducto(Long codProd);
}
