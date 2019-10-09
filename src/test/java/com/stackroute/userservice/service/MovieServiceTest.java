package com.stackroute.userservice.service;
import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Exceptions.MovieNotFoundException;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Repository.MovieRepository;
import com.stackroute.userservice.Service.MovieServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MovieServiceTest {


    Movie movie;
    @Mock
    MovieRepository movieRepository;
    @InjectMocks
    MovieServiceImpl movieService;
    List<Movie> list= null;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        movie = new Movie();
        movie.setId(1);
        movie.setOriginal_title("Bangalore Days");
        movie.setOriginal_language("Malayalam");
        movie.setRelease_date("12-10-2015");
        list = new ArrayList<>();
        list.add(movie);


    }

    @Test
    public void saveMovieTestSuccess() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Boolean savedMovie = movieService.saveMovie(movie);
        Assert.assertEquals(true,savedMovie);
        verify(movieRepository,times(1)).save(movie);
      
    }

    @Test(expected = MovieAlreadyExistsException.class)
    public void saveMovieTestFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(null);
        Boolean savedMovie = movieService.saveMovie(movie);
    }
    @Test
    public void updateMovieTestSuccess() throws MovieAlreadyExistsException {

        when(movieRepository.save((Movie)any())).thenReturn(movie);
        Boolean updatedMovie = movieService.updateMovie(movie);
        Assert.assertEquals(true,updatedMovie);
        verify(movieRepository,times(1)).save(movie);

    }
    @Test(expected = MovieAlreadyExistsException.class)
    public void updateMovieTestFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie)any())).thenReturn(null);
        Boolean updatedMovie = movieService.updateMovie(movie);
    }

    @Test
    public void getAllMovie(){

        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> movielist = movieService.getAllMovies();
        Assert.assertEquals(list,movielist);

    }

    @Test
    public void deleteMovieTestSuccess() throws MovieNotFoundException {
        when(movieRepository.existsById(any())).thenReturn(true);
        Boolean deletedMovie = movieService.deleteMovie(1);
        Assert.assertEquals(true,deletedMovie);
        verify(movieRepository,times(1)).deleteById(1L);
        verify(movieRepository,times(1)).existsById(1L);
    }

    @Test(expected = MovieNotFoundException.class)
    public void deleteMovieTestFailure() throws MovieNotFoundException {
        when(movieRepository.existsById(any())).thenReturn(false);
        Boolean deletedMovie = movieService.deleteMovie(1);
    }
    @Test
    public void findByNameTestSuccess() throws MovieNotFoundException {
        when(movieRepository.findByTitle(anyString())).thenReturn(list);
       List<Movie> findMovie=movieService.findByName("Om Shanti Oshana");
        Assert.assertEquals(list,findMovie);
        verify(movieRepository,times(1)).findByTitle("Om Shanti Oshana");
    }
    @Test(expected = MovieNotFoundException.class)
    public void findByNameTestFailure() throws MovieNotFoundException {
        when(movieRepository.findByTitle(anyString())).thenReturn(new ArrayList<>());
        List<Movie> findMovie=movieService.findByName("Om Shanti Oshana");
    }



}
