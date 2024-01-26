package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
