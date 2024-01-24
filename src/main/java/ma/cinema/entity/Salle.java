package ma.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Salle {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private int nombrePlaces ;

    @ManyToOne
    private Cinema cinema ;
    @OneToMany(mappedBy = "salle" , fetch = FetchType.LAZY)
    private List<Place> places ;
    @ManyToMany()
    List<Film> films ;
}
