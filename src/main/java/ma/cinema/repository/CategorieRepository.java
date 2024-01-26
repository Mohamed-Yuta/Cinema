package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
