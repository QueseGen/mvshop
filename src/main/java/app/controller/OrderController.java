package app.controller;

import app.model.Order;
import app.controller.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
  @Autowired
  private OrderService orderService;

  @PostMapping("/addOrder")
  public Order createOrder(@RequestBody Order order){ return orderService.createOrder(order);}

  @PostMapping("/addOrders")
  public List<Order> createOrders( @RequestBody List<Order> orders){ return orderService.createOrders(orders);}

  @GetMapping("/Orders")
  public List<Order> readOrders(){return orderService.readOrders();}

  @GetMapping("/Orders/r/user={username}")
  //@ResponseBody
  public List<Order> OrdersbyUsername(@RequestParam List<Order> order, @PathVariable String  username){return orderService.readByUsername(username);}

  @DeleteMapping("/Orders/d/id={id}")
  public String deleteOrder(@PathVariable Integer id){return orderService.deleteOrder(id);}
}
