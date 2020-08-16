package com.Examen3P2.graphql.mutation;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Examen3P2.graphql.entity.Movie;
import com.Examen3P2.graphql.service.MovieService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class MovieMutation implements GraphQLMutationResolver {

	@Autowired
	private MovieService movieService;

	public Movie createMovie(String title, int budget, double runtime, String language, Date release) {

		Movie m = new Movie(title, budget, runtime, language, release);
		
		return this.movieService.createMovie(m);

	}
	
	public Movie deleteMovie(String movieId) {
		
		return this.movieService.deleteMovie(movieId);
	}
	
	public Movie updateMovie(String title, int budget, double runtime, String language, Date release) {
		
		Movie m = new Movie(title, budget, runtime, language, release);
		
		return this.movieService.updateMovie(title, m);
	}
}
