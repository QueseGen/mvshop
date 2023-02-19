package app.controller.repos;

import app.model.Order;
import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  @Query("SELECT f FROM User f WHERE LOWER(f.email) = LOWER(:email)")
  User findByEmail(@Param("email") String email);
  @Query("SELECT f FROM User f WHERE LOWER(f.username) = LOWER(:username)")
 User findByUsername(@Param("username") String username);
}
