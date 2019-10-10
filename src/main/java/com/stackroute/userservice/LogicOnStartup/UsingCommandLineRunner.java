package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Repository.MovieRepository;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class UsingCommandLineRunner implements CommandLineRunner {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public void run(String... args) throws MovieAlreadyExistsException {
        movieRepository.deleteAll();
    }
}
