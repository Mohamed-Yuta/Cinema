package ma.cinema.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Place {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private int numero ;
    private double latitude , longtitude , atitude ;
    @ManyToOne
    private Salle salle ;
    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY)
    List<Ticket> tickets ;

}
