package app.controller.repos;

import app.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

  @Query("SELECT f FROM Order f WHERE LOWER(f.Name) = LOWER(:name)")
  Order findByName(@Param("name") String name);
  @Query("SELECT f FROM Order f WHERE LOWER(f.Username) = LOWER(:username)")
  List<Order> findByUsername(@Param("username") String username);

}
