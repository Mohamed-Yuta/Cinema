package ma.cinema.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.cinema.entity.Cinema;
import ma.cinema.entity.Salle;
import ma.cinema.entity.Ville;
import ma.cinema.repository.*;
import org.springframework.stereotype.Service;

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

    }

    @Override
    public void initFilms() {

    }

    @Override
    public void initProjectionFilm() {

    }

    @Override
    public void initTickets() {

    }

    @Override
    public void initSeances() {

    }

    @Override
    public void initCategories() {

    }
}
