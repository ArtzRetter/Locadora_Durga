package durga.locadora.controller;

import durga.locadora.dto.MovieDto;
import durga.locadora.service.MovieService;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/movie")
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createMovie(
            @RequestParam(name = "title", required = true) String movieTitle,
            @RequestParam(name = "genre", required = true) String movieGenre,
            @RequestParam(name = "stock", required = true) int movieStock
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(movieTitle,movieGenre,movieStock));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> movieList(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovie());
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> deleteMovie(
            @RequestParam (name = "movieId", required = true) String movieId
    ){
        movieService.delMovieList(movieId);
        return ResponseEntity.status(HttpStatus.OK).body("filme deletado");
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateMovie(
            @NonNull
            @RequestBody MovieDto updateMovie){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(updateMovie));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Você precisa preencher todos os campos");
        }
    }

}
