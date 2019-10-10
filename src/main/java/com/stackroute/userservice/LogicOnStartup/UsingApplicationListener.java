package com.stackroute.userservice.LogicOnStartup;
import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Repository.MovieRepository;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
public class UsingApplicationListener implements ApplicationListener<ContextRefreshedEvent>   {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       movieRepository.deleteAll();
    }
}
