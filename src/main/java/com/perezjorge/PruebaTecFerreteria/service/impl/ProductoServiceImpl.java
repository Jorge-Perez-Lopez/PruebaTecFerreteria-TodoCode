package com.perezjorge.PruebaTecFerreteria.service.impl;

import com.perezjorge.PruebaTecFerreteria.model.Producto;
import com.perezjorge.PruebaTecFerreteria.repository.ProductoRepository;
import com.perezjorge.PruebaTecFerreteria.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductoServiceImpl implements ProductoService {

    private  final ProductoRepository prodRepo;

    public ProductoServiceImpl(ProductoRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    @Override
    public List<Producto> traerProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Producto buscarProducto(Long codProd) {
        return prodRepo.findById(codProd).orElse(null);
    }

    @Override
    public Producto crearProducto(Producto prod) {

        // VAlidación de que el rpoducto no sea null

        if (prod==null) {
            return null;
        }

        // Id se genera automáticamente en la BD y con etso la devolvemos junto el producto

      return prodRepo.save(prod);
    }

    @Override
    public Producto editarProducto(Long codProd, Producto prod) {

        // buscar si existe el producto
        Producto prodExistente= buscarProducto(codProd);

        // validación

        if (prodExistente==null) {
            return null;
        }

        // Actualizamos los datos con el producto

        prodExistente.setCategoria(prod.getCategoria());
        prodExistente.setDescripcion(prod.getDescripcion());
        prodExistente.setMarca(prod.getMarca());
        prodExistente.setStock(prod.getStock());
        prodExistente.setPrecio(prod.getPrecio());
        prodExistente.setNombre(prod.getNombre());

        return prodRepo.save(prodExistente);

    }

    @Override
    public boolean eliminarProducto(Long codProd) {
        Producto prodExistente= buscarProducto(codProd);

        if (prodExistente == null) {
            return  false;
        }

        prodRepo.delete(prodExistente);

        return true;
    }
}
