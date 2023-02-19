package app.controller.service;

import app.model.User;
import app.controller.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
  @Autowired
  private UserRepository repository;
  public User createUser(User user){ return repository.save(user);}
  public List<User> createUsers(List<User> user){ return repository.saveAll(user);}
  public User readUser(Integer id){return repository.findById(id).orElse(null);}
  public List<User> readUsers(){ return repository.findAll();}

  public User readByUsername(String username){return repository.findByUsername(username);}

  public User readByEmail(String email){return repository.findByEmail(email);}
  public User updateUser(Integer id){
    User existingUser = repository.findById(id).orElse(null);
    assert existingUser != null;
    existingUser.setAdmin(true);
    return repository.save(existingUser);}
public String deleteUser(Integer id){repository.deleteById(id); return "User deleted"; }
}
