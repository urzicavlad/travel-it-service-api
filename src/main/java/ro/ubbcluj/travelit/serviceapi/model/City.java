package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 256)
    private String name;
    @ManyToOne
    private Country country;
    @Column(length = 15000)
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Recommendation> recommendations;

}
