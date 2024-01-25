package ma.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor

public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;


    @OneToMany(mappedBy = "categorie")
    List<Film> films ;
}
