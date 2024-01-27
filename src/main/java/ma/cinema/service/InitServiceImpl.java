package ma.cinema.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.cinema.entity.*;
import ma.cinema.repository.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
@AllArgsConstructor
@Transactional
public class InitServiceImpl implements InitService{
    private final VilleRepository villeRepository ;
    private final CinemaRepository cinemaRepository ;
    private final FilmRepository filmRepository ;
    private final CategorieRepository categorieRepository ;
    private final SalleRepository salleRepository ;
    private final PlaceRepository placeRepository ;
    private final SeanceRepository seanceRepository ;
    private final ProjectionFilmRepository projectionFilmRepository;
    private final TicketRepository ticketRepository ;


    @Override
    public void initVilles() {
        Ville ville = new Ville() ;
        ville.setName("Casablanca");
        ville.setLatitude(33.5898);
        ville.setAttitude(27);
        ville.setLongtitude(33.5888);
        villeRepository.save(ville);
        Ville ville2 = new Ville() ;
        ville2.setName("Rabat");
        ville2.setLatitude(33.5898);
        ville2.setAttitude(27);
        ville2.setLongtitude(33.5888);
        villeRepository.save(ville2);
    }

    @Override
    public void initCinemas() {
        villeRepository.findAll().stream().forEach(ville -> {
            Cinema cinema = new Cinema();
            cinema.setName("Megarama");
            cinema.setNombreSalles(10);
            cinema.setVille(ville);
            ville.getCinemas().add(cinema);

            cinemaRepository.save(cinema);
            Cinema cinema2 = new Cinema();
            cinema2.setName("Fonon");
            cinema2.setVille(ville);
            cinema2.setNombreSalles(5);
            cinemaRepository.save(cinema2);
            ville.getCinemas().add(cinema2);
            villeRepository.save(ville);
        });
    }

    @Override
    public void initSalles() {
        cinemaRepository.findAll().stream().forEach(cinema -> {
            for (int i =1 ; i<=cinema.getNombreSalles() ; i++ ){
                Salle salle = new Salle();
                salle.setNombrePlaces((int) (Math.random()*10));
                salle.setName("salle"+i);
                salle.setCinema(cinema);
                cinema.getSalles().add(salle);
                cinemaRepository.save(cinema);
                salleRepository.save(salle);
            }
        });
    }

    @Override
    public void initPlaces() {
        salleRepository.findAll().stream().forEach(salle -> {
            for (int i =1 ; i<= salle.getNombrePlaces();i++) {
                Place place = new Place();
                place.setNumero(i);
                place.setSalle(salle);
                placeRepository.save(place);
                salle.getPlaces().add(place);
            }
        });
    }
    @Override
    public void initCategories() {
        Categorie categorie = new Categorie();
        categorie.setName("Action");
        categorieRepository.save(categorie);
        Categorie categorie1 = new Categorie();
        categorie1.setName("Drama");
        categorieRepository.save(categorie1);
        Categorie categorie2 = new Categorie();
        categorie2.setName("Romance");
        categorieRepository.save(categorie2);
    }

    @Override
    public void initFilms() {
        categorieRepository.findAll().stream().forEach(categorie -> {
            Film film = new Film();
            film.setTitre("Good will Hunting");
            film.setCategorie(categorie);
            categorie.getFilms().add(film);
            filmRepository.save(film);
            categorieRepository.save(categorie);
        });
    }
    @Override
    public void initSeances() {
        for(int i =1 ; i<15;i++){
            Seance seance = new Seance();
            seance.setHeureDebut(new Date());
            seanceRepository.save(seance);
        }
    }

    @Override
    public void initProjectionFilm() {
        salleRepository.findAll().stream().forEach(salle -> {
            filmRepository.findAll().stream().forEach(film -> {
                seanceRepository.findAll().stream().forEach(seance -> {
                    ProjectionFim projectionFim = new ProjectionFim();
                    projectionFim.setPrix(50.0); // Set the price as needed
                    projectionFim.setDateProjection(new Date());
                    projectionFim.setSalle(salle);
                    projectionFim.setFilm(film);
                    projectionFim.setSeance(seance);

                    projectionFilmRepository.save(projectionFim);
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionFilmRepository.findAll().stream().forEach(projectionFim -> {
            salleRepository.findAll().stream().forEach(salle -> {
                for (Place place : salle.getPlaces()) {
                    Ticket ticket = new Ticket();
                    ticket.setNomClient("Client" + new Random().nextInt(1000));
                    ticket.setPrix(projectionFim.getPrix());
                    ticket.setCodePayement(new Random().nextInt(10000));
                    ticket.setPlace(place);
                    ticket.setProjectionFim(projectionFim);

                    ticketRepository.save(ticket);}
            });
        });

    }




}
