package app.model.exceptions;
public class UserNotFoundException extends RuntimeException {
  UserNotFoundException(Integer id) {
      super("Could not find product " + id);
    }
  }
