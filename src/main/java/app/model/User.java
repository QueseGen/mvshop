package app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "ISADMIN")
    private boolean admin;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PWD")
    private String password;

}
