package com.fpt.csw_final_api.controller;

import com.fpt.csw_final_api.entity.Product;
import com.fpt.csw_final_api.service.ProductService;
import com.fpt.csw_final_api.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> findAllProduct() {
        List<Product> lsProduct = productService.getAllProducts();
        if(lsProduct.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(lsProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public ResponseEntity<Product> saveNewProduct(@RequestBody Product u) {
        productService.addProduct(u);
        return new ResponseEntity<Product>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "product/sell", method = RequestMethod.PUT)
    public ResponseEntity<Product> sellProduct(@PathParam("productId") int productId, @PathParam("quantity") int quantity) {
        Product product =productService.findById(productId);
        product.setQuantity(product.getQuantity() - quantity);
        productService.saveProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findUserById(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
