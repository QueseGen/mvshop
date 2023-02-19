package app.controller.service;

import app.model.Product;
import app.controller.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;
  public Product createProduct(Product product){ return repository.save(product);}
  public List<Product> createProducts(List<Product> product){ return repository.saveAll(product);}
  public Product readProduct(Integer id){return repository.findById(id).orElse(null);}
  public List<Product> readProducts(){ return repository.findAll();}
  public List<Product> readByProductName(String name){return repository.findByName(name);}
  public Product updateProduct(Integer id){
    Product existingProduct = repository.findById(id).orElse(null);
    assert existingProduct != null;
    existingProduct.setQuantity(0);
    return repository.save(existingProduct);}
  public String deleteProduct(Integer id){repository.deleteById(id); return "Product deleted"; }
}
