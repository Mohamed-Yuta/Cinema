package ma.cinema.repository;

import ma.cinema.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository  extends JpaRepository<Cinema , Long> {
}
