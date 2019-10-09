package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UsingCommandLineRunner implements CommandLineRunner {
    private static MovieService movieService;
    private static Movie movie=new Movie();
    public UsingCommandLineRunner(MovieService movieService) {
        this.movieService=movieService;
    }
    @Override
    public void run(String... args) throws MovieAlreadyExistsException {
        movie.setId(2);
        movie.setOriginal_title("Om Shanti Oshana");
        movie.setOriginal_language("Malayalam");
        movie.setRelease_date("15-06-2011");
//        movieService.saveMovie(movie);
    }
}
