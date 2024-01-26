package ma.cinema.repository;

import ma.cinema.entity.Categorie;
import ma.cinema.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
