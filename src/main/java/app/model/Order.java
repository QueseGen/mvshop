package app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "NAME")
    private String Name;

  @Column(name = "USERNAME")
  private String Username;
    @Column(name ="QUANTITY")
    private int Quanity;

    @Column(name= "SUBTOTAL")
    private float SubTotal;
    @Column(name = "TOTAL")
    private float Total;

    @Column(name = "Checkedout")
    private boolean Checkedout;
}
