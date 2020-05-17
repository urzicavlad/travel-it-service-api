package ro.ubbcluj.travelit.serviceapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 256)
    private String name;
    @Column(length = 256)
    private String address;
    @Column(length = 15000)
    private String description;

}
