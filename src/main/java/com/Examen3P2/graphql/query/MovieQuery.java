package com.Examen3P2.graphql.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Examen3P2.graphql.entity.Movie;
import com.Examen3P2.graphql.service.MovieService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class MovieQuery implements GraphQLQueryResolver {

	@Autowired
	private MovieService movieService;

	public List<Movie> getMovies() {
		return this.movieService.getAllMovies();
	}

	public Optional<Movie> getMovie(String movieId) {
		return this.movieService.getMovie(movieId);
	}

	public List<Movie> getMoviesByYear(int year) {

		return this.movieService.getMoviesByYear(year);
	}
	
	public List<Movie> getMoviesByTitle(String movieId) {

		return this.movieService.getMoviesByTitle(movieId);
	}
	
	
}
