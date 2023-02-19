package app.controller.repos;

import app.model.Order;
import app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  @Query("SELECT f FROM Product f WHERE LOWER(f.Name) = LOWER(:name)")
  List<Product> findByName(@Param("name") String name);

}
