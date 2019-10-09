package com.stackroute.userservice.Service;

import com.stackroute.userservice.Exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.Exceptions.MovieNotFoundException;
import com.stackroute.userservice.Model.Movie;

import java.util.List;
public interface MovieService {
    public boolean saveMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> getAllMovies();
    public boolean deleteMovie(long id) throws MovieNotFoundException;
    public boolean updateMovie(Movie movie) throws MovieAlreadyExistsException;
    public List<Movie> findByName(String string) throws MovieNotFoundException;
}
