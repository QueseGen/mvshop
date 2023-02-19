package app.controller;

import app.model.Product;
import app.controller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping("/addProduct")
  public Product createProduct(@RequestBody Product product){ return productService.createProduct(product);}

  @PostMapping("/addProducts")
  public List<Product> createProducts( @RequestBody List<Product> products){ return productService.createProducts(products);}

  @GetMapping("/Products")
  public List<Product> readProducts(){return productService.readProducts();}

  @GetMapping("/Products/r/name={name}")
  //@ResponseBody
  public List<Product> ProductsbyName(@RequestParam List<Product> product, @PathVariable String  name){return productService.readByProductName(name);}

  @DeleteMapping("/Products/d/id={id}")
  public String deleteProduct(@PathVariable Integer id){return productService.deleteProduct(id);}
}
