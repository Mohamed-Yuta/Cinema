package ma.cinema.repository;

import ma.cinema.entity.Cinema;
import ma.cinema.entity.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, Long> {

    Ville findByName(String name);
}
