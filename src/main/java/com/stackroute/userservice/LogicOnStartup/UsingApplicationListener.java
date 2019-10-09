package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
public class UsingApplicationListener implements ApplicationListener<ContextRefreshedEvent>   {
    private static MovieService movieService;
    private static Movie movie=new Movie();
    public UsingApplicationListener(MovieService movieService) {
        this.movieService=movieService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        movie.setId(1);
        movie.setOriginal_title("Bangalore Days");
        movie.setOriginal_language("Malayalam");
        movie.setRelease_date("20-02-2014");
//        try {
//            movieService.saveMovie(movie);
//        } catch (MovieAlreadyExistsException e) {
//            e.printStackTrace();
//        }
    }
}
