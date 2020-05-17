package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Accessors(chain = true)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 256)
    private String name;
    @Column(length = 15000)
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Recommendation> recommendations;

}
