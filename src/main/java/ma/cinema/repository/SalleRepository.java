package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Long> {
}
