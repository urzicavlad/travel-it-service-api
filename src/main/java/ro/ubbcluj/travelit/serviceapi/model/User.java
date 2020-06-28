package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String avatar;
    @Column
    private String originCountry;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Country> favouriteDestinations;
    private String role;
}
