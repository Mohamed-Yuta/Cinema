package ma.cinema.service;

import lombok.AllArgsConstructor;
import ma.cinema.entity.Categorie;
import ma.cinema.entity.Cinema;
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


}
