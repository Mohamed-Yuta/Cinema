package ma.cinema.service;

import lombok.AllArgsConstructor;
import ma.cinema.entity.Film;
import ma.cinema.exceptions.FilmNotFoundException;
import ma.cinema.repository.FilmRepository;

import java.util.List;

@AllArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository ;

    public List<Film> filmList(){
        return filmRepository.findAll();
    }
    public Film film(Long id) throws FilmNotFoundException {
        return filmRepository.findById(id).orElseThrow(()->new FilmNotFoundException("film not found"));
    }
    public Film addFilm(Film film )  {
       return filmRepository.save(film);
    }
    public void deleteFilm(Long id){
         filmRepository.deleteById(id);
    }
    public Film updateFilm(Film film , Long id){
        film.setId(id);
        return filmRepository.save(film);
    }

}
