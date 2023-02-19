package app.controller.service;

import app.model.Order;
import app.controller.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
  @Autowired
  private OrderRepository repository;
  public Order createOrder(Order order){ return repository.save(order);}
  public List<Order> createOrders(List<Order> orders){ return repository.saveAll(orders);}
  public Order readOrder(Integer id){return repository.findById(id).orElse(null);}
  public List<Order> readOrders(){ return repository.findAll();}
  public Order readByOrderName(String ordername){return repository.findByName(ordername);}
  public List<Order> readByUsername(String username){return repository.findByUsername(username);}
  public Order updateOrder(Integer id){
    Order existingOrder = repository.findById(id).orElse(null);
    assert existingOrder != null;
    existingOrder.setCheckedout(true);
    return repository.save(existingOrder);}
  public String deleteOrder(Integer id){repository.deleteById(id); return "Order deleted"; }
}
