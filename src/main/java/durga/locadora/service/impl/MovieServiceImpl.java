package durga.locadora.service.impl;

import durga.locadora.service.MovieService;
import durga.locadora.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class MovieServiceImpl implements MovieService {

    private ArrayList<MovieDto> movieList = new ArrayList<>();

    @Override
    public ArrayList<MovieDto> createMovie(String movieTitle,String movieGenre, int movieStock){
        movieList.add(
                MovieDto.builder()
                    .movieId(UUID.randomUUID())
                    .movieTitle(movieTitle)
                    .movieGenre(movieGenre)
                    .stock(movieStock)
                    .build()
        );
        return movieList;
    }

    @Override
    public ArrayList<MovieDto> getMovie() {
        return movieList;
    }


    public ArrayList <MovieDto> getMovieList() {return movieList;}

    @Override
    public void delMovieList(String movieId){
        for (MovieDto movie:movieList){
            if (movie.getMovieId().equals(UUID.fromString(movieId))){
                movieList.remove(movie);
            }
        }
    };

    @Override
    public ArrayList<MovieDto> updateMovie(MovieDto updateMovie){
        for (int i=0; 1 < movieList.size(); i++){
            if (movieList.get(i).getMovieId().equals(updateMovie.getMovieId())){
                movieList.set(i,updateMovie);
            }
        }
    return movieList;
    };

}
