package ma.cinema.service;

import lombok.AllArgsConstructor;
import ma.cinema.entity.Categorie;
import ma.cinema.entity.Cinema;
import ma.cinema.entity.Film;
import ma.cinema.entity.Ville;
import ma.cinema.repository.*;

@AllArgsConstructor
public class CinemaService {

    private final VilleRepository villeRepository ;
    private final CinemaRepository cinemaRepository ;
    private final FilmRepository filmRepository ;
    private final CategorieRepository categorieRepository;
    private final PlaceRepository placeRepository ;

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


}
