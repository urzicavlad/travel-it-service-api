package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Accessors(chain = true)
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 256)
    private String name;
    @Column(length = 2)
    private String code;
    @Column(length = 15000)
    private String flag;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<City> cities;
}
