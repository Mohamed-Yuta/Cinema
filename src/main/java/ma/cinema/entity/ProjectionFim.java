package ma.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class ProjectionFim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double prix;
    private Date dateProjection;

    @OneToMany(mappedBy = "projectionFim")
    List<Ticket> tickets ;
    @ManyToOne
    private Salle salle ;
    @ManyToOne
    private  Film film ;
    @OneToOne
    private Seance seance ;
}