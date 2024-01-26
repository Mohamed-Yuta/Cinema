package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
