package ma.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class Cinema {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private Long latitude , longtitude , atitude ;
    private int nombreSalles ;

    @ManyToOne
    private Ville ville ;
    @OneToMany(mappedBy = "cinema" ,fetch = FetchType.LAZY)
    List<Salle> salles ;
}
