package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.Cinema;
import ma.cinema.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Categorie findByName(String name);
}
