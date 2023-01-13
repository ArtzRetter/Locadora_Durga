package durga.locadora.service;

import durga.locadora.dto.MovieDto;
import java.util.ArrayList;

public interface MovieService {

    ArrayList<MovieDto> createMovie (String movieTitle, String movieGenre, int movieStock);

    ArrayList<MovieDto> getMovie();

    void delMovieList (String movieId);

    ArrayList<MovieDto> updateMovie (MovieDto updateMovie);
}
