package com.perezjorge.PruebaTecFerreteria.controller;

import com.perezjorge.PruebaTecFerreteria.model.Producto;
import com.perezjorge.PruebaTecFerreteria.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")

public class ProductoRestController {

    private final ProductoService prodServ;

    public ProductoRestController(ProductoService prodServ) {
        this.prodServ = prodServ;
    }
    // READ
    @GetMapping
    public List<Producto> traerProductos() {
        return prodServ.traerProductos();
    }

    // READ de producto específico

    @GetMapping("/{codProd}")
    public ResponseEntity<?> buscarProducto(@PathVariable Long codProd) {

        Producto prod = prodServ.buscarProducto(codProd);

        if (prod == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra un producto con ese código");
        }

        return ResponseEntity.ok(prod);
    }

    // CREATE

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Producto prod) {

        Producto productoCreado = prodServ.crearProducto(prod);

        if (productoCreado == null) {

            return ResponseEntity.badRequest().body("Los datos del producto no son válidos");
        }

        return ResponseEntity.status((HttpStatus.CREATED)).body(productoCreado);
    }

    // UPDATE

    @PutMapping("/{codProd}")
    public ResponseEntity<?> editarProducto(@PathVariable Long codProd, @RequestBody Producto prodAModificar) {

        Producto prodEditado = prodServ.editarProducto(codProd, prodAModificar);

        if (prodEditado == null) {

            return ResponseEntity.badRequest().body("No fue posible editar el producto");

        }

        return ResponseEntity.ok(prodEditado);
    }

    // DELETE
    @DeleteMapping("/{codProd}")
    public ResponseEntity<String> eliliminarProducto(@PathVariable Long codProd) {

        boolean eliminado = prodServ.eliminarProducto(codProd);

        if (!eliminado) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado un producto con el código: " + codProd);
        }

        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
