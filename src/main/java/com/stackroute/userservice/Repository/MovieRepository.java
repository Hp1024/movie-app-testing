package com.stackroute.userservice.Repository;

import com.stackroute.userservice.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query(value = "SELECT * FROM  Movie m WHERE m.original_title= :movietitle",
            nativeQuery=true
    )
    public List<Movie> findByTitle(@Param("movietitle")String string);
}
