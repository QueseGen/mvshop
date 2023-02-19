package app.model.exceptions;
public class OrderNotFoundException extends RuntimeException {
  OrderNotFoundException(Integer id) {
      super("Could not find product " + id);
    }
  }
