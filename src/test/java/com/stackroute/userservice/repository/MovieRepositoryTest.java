package com.stackroute.userservice.repository;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Repository.MovieRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;
    Movie movie;

    @Before
    public void setUp()
    {
        movie = new Movie();
        movie.setId(1);
        movie.setOriginal_title("Bangalore Days");
        movie.setOriginal_language("Malayalam");
        movie.setRelease_date("12-10-2015");

    }

    @After
    public void tearDown(){

        movieRepository.deleteAll();
    }


    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        System.out.println(movieRepository.findAll());
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertEquals(1,fetchMovie.getId());

    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(56,"Hello","telugu","15-06-2016");
        movieRepository.save(movie);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertNotSame(testMovie,movie);
    }

    @Test
    public void testGetAllMovie(){
        Movie u = new Movie(1,"Om Shanti Oshana","Malayalam","15-06-2016");
        Movie u1 = new Movie(2,"Saira","telugu","15-06-2016");
        movieRepository.save(u);
        movieRepository.save(u1);
        System.out.println(movieRepository.findAll());
        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals(1,list.get(0).getId());
        Assert.assertEquals(2,list.get(1).getId());
    }
    @Test
    public void testUpdateMovie(){
        movieRepository.save(movie);
        Movie u = new Movie(1,"Om Shanti Oshana","Malayalam","15-06-2016");
        movieRepository.save(u);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertEquals("Om Shanti Oshana",fetchMovie.getOriginal_title());

    }

    @Test
    public void testUpdateMovieFailure(){
        movieRepository.save(movie);
        Movie u = new Movie(1,"Om Shanti Oshana","Malayalam","15-06-2016");
        movieRepository.save(u);
        Movie fetchMovie = movieRepository.findById(movie.getId()).get();
        Assert.assertNotEquals("Bangalore Days",fetchMovie.getOriginal_title());
    }
    @Test
    public void testDeleteMovie(){
        movieRepository.save(movie);
        movieRepository.deleteById(1L);
        Assert.assertSame(true,movieRepository.findAll().isEmpty());

    }

    @Test
    public void testDeleteMovieFailure(){
        movieRepository.save(movie);
        movieRepository.deleteById(1L);
        Assert.assertNotSame(false,movieRepository.findAll().isEmpty());
    }
    @Test
    public void testFindByTitleMovie(){
        movieRepository.save(movie);
        List<Movie> findMovie=movieRepository.findByTitle("Bangalore Days");
        Assert.assertEquals(false,findMovie.isEmpty());

    }

    @Test
    public void testFindByTitleMovieFailure(){
        movieRepository.save(movie);
        List<Movie> findMovie=movieRepository.findByTitle("Bangalore Days");
        Assert.assertNotEquals(true,findMovie.isEmpty());
    }

}
