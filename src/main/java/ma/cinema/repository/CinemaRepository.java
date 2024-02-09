package ma.cinema.repository;

import ma.cinema.entity.Cinema;
import ma.cinema.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository  extends JpaRepository<Cinema , Long> {
    Cinema findByName(String name);
}
