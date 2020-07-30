package com.hardhwpc.backend.controllers.rest;


import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.services.ProductService;
import com.hardhwpc.backend.support.exceptions.ProductAlreadyExistException;
import com.vaadin.flow.component.page.Viewport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/adminsproducts")
public class AdminsProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Product product) {
        try {
            productService.registerProduct(product);
        } catch (ProductAlreadyExistException e) {
            return new ResponseEntity<>(new ResponseMessage("Product already exist!"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseMessage("Added successful!"), HttpStatus.OK); // esempio va tornato l'utente
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.showAllProducts();
    }

    @PutMapping("/id")
    public @ResponseBody Product updateProduct(@PathVariable BigInteger id,
                                               @Valid @RequestBody Product newProduct){
            return productService.updateProduct(id,newProduct);
    }

    @DeleteMapping("/id")
    public void deleteProduct(@PathVariable BigInteger id){
        productService.delete(id);
    }


}
