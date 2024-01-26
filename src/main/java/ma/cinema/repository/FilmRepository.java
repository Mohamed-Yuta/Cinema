package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
