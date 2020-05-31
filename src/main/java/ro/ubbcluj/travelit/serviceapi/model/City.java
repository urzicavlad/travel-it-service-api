package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
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
    @JoinColumn(name ="city_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Recommendation> recommendations;

}
