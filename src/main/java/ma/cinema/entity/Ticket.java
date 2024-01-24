package ma.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String nomClient ;
    private double prix ;
    private int codePayement ;

    @ManyToOne()
    private Place place;
    @ManyToOne
    private ProjectionFim projectionFim ;

}
