package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.ProjectionFim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectionFilmRepository extends JpaRepository<ProjectionFim, Long> {
}
