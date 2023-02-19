package app.controller;

import app.model.User;
import app.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/addUser")
  public User createUser(@RequestBody User user){ return userService.createUser(user);}

  @PostMapping("/addUsers")
  public List<User> createUsers( @RequestBody List<User> users){ return userService.createUsers(users);}

  @GetMapping("/Users")
  public List<User> readUsers(){return userService.readUsers();}

  @GetMapping("/Users/r/user={username}")
  //@ResponseBody
  public User UsersbyUsername(@RequestParam User user, @PathVariable String username){return userService.readByUsername(username);}

  @GetMapping("/Users/r/email={email}")
  //@ResponseBody
  public User UsersbyEmail(@RequestParam User user, @PathVariable String email){return userService.readByEmail(email);}

  @DeleteMapping("/Users/d/id={id}")
  public String deleteUser(@PathVariable Integer id){return userService.deleteUser(id);}
}
