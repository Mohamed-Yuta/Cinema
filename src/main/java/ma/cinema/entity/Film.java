package ma.cinema.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Film {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String titre ;
    private double duree ;
    private String realisateur ;
    private String description ;
    private String photo ;
    private String dateSortie ;

    @ManyToOne
    private Categorie categorie ;
    @OneToMany(mappedBy = "film")
    List<ProjectionFim> list ;


}
