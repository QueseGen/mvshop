package app.controller.rest.assured;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

  @GetMapping("/")
  public String hello(){
    return "Hello World";
  }

  public static void main(String[] args) {
  }
}
