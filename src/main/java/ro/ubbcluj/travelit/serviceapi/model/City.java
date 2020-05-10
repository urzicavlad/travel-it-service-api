package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 256)
    private String name;
    @Column(length = 50000)
    private String description;
    @OneToMany(cascade=CascadeType.ALL)
    private Set<Recommendation> recommendations;

}
