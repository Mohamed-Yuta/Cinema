package ma.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class Seance {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private Date heureDebut ;
    @OneToOne
    private ProjectionFim projectionFim;

}
