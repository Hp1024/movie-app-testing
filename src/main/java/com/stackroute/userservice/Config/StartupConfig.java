package com.stackroute.userservice.Config;

import com.stackroute.userservice.LogicOnStartup.UsingApplicationListener;
import com.stackroute.userservice.LogicOnStartup.UsingCommandLineRunner;
import com.stackroute.userservice.Model.Movie;
import com.stackroute.userservice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class StartupConfig {
    @Autowired
    private MovieService movieService;
    @Bean
    public UsingApplicationListener applicationListener(){
        UsingApplicationListener usingApplicationListener=new UsingApplicationListener(movieService);
        return usingApplicationListener;
    }
    @Bean
    public UsingCommandLineRunner commandLineRunner(){
        UsingCommandLineRunner usingCommandLineRunner=new UsingCommandLineRunner(movieService);
        return usingCommandLineRunner;
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("movie1")
    @ConfigurationProperties(prefix = "save")
    public Movie movieBeanSave(){
        return new Movie();
    }
    @Bean("movie2")
    @ConfigurationProperties(prefix = "update")
    public Movie movieBeanUpdate(){
        return new Movie();
    }

}
