package ma.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Ville {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private double attitude ;
    private double longtitude ;
    private double latitude ;

    @OneToMany(mappedBy = "ville" ,fetch = FetchType.EAGER)
    List<Cinema> cinemas = new ArrayList<>();




}
