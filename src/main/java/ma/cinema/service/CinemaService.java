package ma.cinema.service;

import lombok.AllArgsConstructor;
import ma.cinema.entity.*;
import ma.cinema.repository.*;

import java.util.Date;

@AllArgsConstructor
public class CinemaService {

    private final VilleRepository villeRepository ;
    private final CinemaRepository cinemaRepository ;
    private final FilmRepository filmRepository ;
    private final CategorieRepository categorieRepository;
    private final PlaceRepository placeRepository ;
    private final SalleRepository salleRepository;
    private final SeanceRepository seanceRepository ;
    private ProjectionFilmRepository projectionFilmRepository;
    private final TicketRepository ticketRepository ;
    Ville saveVille(String name ) {
        Ville ville = new Ville();
        ville.setName(name);

        return villeRepository.save(ville);
    }
    Cinema saveCinema(String name , String cinemaName , int nbre) {
        Cinema cinema = new Cinema();
        Ville ville = villeRepository.findByName(name);
        cinema.setVille(ville);
        cinema.setNombreSalles(nbre);
        cinema.setName(cinemaName);
        ville.getCinemas().add(cinema);
        villeRepository.save(ville);
        return cinemaRepository.save(cinema);
    }
    Categorie saveCategorie(String name ) {
        Categorie categorie = new Categorie();
        categorie.setName(name);
        return categorieRepository.save(categorie);
    }
    Film saveFilm(String categ , String name){
        Categorie categorie = categorieRepository.findByName(name);
        Film film = new Film();
        film.setCategorie(categorie);
        film.setTitre(name);
        categorie.getFilms().add(film);
        categorieRepository.save(categorie);
        return filmRepository.save(film);
    }
    Salle saveSalle(String name , String cinema , int nbr){
        Cinema cinema1 = cinemaRepository.findByName(cinema);
        Salle salle = new Salle();
        salle.setCinema(cinema1);
        salle.setNombrePlaces(nbr);
        salle.setName(name);
        cinema1.getSalles().add(salle);
        cinemaRepository.save(cinema1);
        return salleRepository.save(salle);
    }
    Seance saveSeance(Date heureDebut) {

        Seance seance = new Seance();
        seance.setHeureDebut(heureDebut);

        return seanceRepository.save(seance);
    }
    Place savePlace(int numero, double latitude, double longitude, double altitude, Long salleId) {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new RuntimeException("Salle not found"));

        Place place = new Place();
        place.setNumero(numero);
        place.setLatitude(latitude);
        place.setLongtitude(longitude);
        place.setAtitude(altitude);
        place.setSalle(salle);

        salle.getPlaces().add(place);
        salleRepository.save(salle);
        return placeRepository.save(place);
    }
    ProjectionFim saveProjectionFim(double prix, Date dateProjection, Long salleId, Long filmId, Long seanceId) {
        Salle salle = salleRepository.findById(salleId).orElseThrow(() -> new RuntimeException("Salle not found"));
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new RuntimeException("Film not found"));
        Seance seance = seanceRepository.findById(seanceId).orElseThrow(() -> new RuntimeException("Seance not found"));

        ProjectionFim projectionFim = new ProjectionFim();
        projectionFim.setPrix(prix);
        projectionFim.setDateProjection(dateProjection);
        projectionFim.setSalle(salle);
        projectionFim.setFilm(film);
        projectionFim.setSeance(seance);

        salle.getList().add(projectionFim);
        film.getList().add(projectionFim);
        seance.setProjectionFim(projectionFim);

        salleRepository.save(salle);
        filmRepository.save(film);
        seanceRepository.save(seance);

        return projectionFilmRepository.save(projectionFim);
    }

}
