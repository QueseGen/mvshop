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
@Table(name= "products")
public class Product {
    //VARIABLES
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "PRICE")
    private float Price;
    @Column(name = "QUANTITY")
    private int Quantity;
    @Column(name = "DESCRIPTION")
    private String Description;
}
