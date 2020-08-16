package com.Examen3P2.graphql.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Examen3P2.graphql.entity.Movie;
import com.Examen3P2.graphql.repository.MovieRepository;

@Service
public class MovieService{

	@Autowired
	private MovieRepository movieRepository;

	@Transactional(readOnly = true)
	public List<Movie> getAllMovies() {
		return this.movieRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Movie> getMovie(String movieId) {
		return this.movieRepository.findById(movieId);
	}

	@Transactional(readOnly = true)
	public List<Movie> getMoviesByYear(int year) {

		List<Movie> movies = movieRepository.findAll();

		return movies.stream().filter(p -> p.getYear() == year).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public List<Movie> getMoviesByTitle(String movieId) {
		return movieRepository.findBytitleContainingIgnoreCase(movieId);
	}
	
	public Movie createMovie(Movie newMovie) {
		return this.movieRepository.save(newMovie);
	}
	
	public Movie deleteMovie(String movieId) {
		
		Optional<Movie> m = movieRepository.findById(movieId);
		
		if (m.get() != null) {
			movieRepository.delete(m.get());
			return m.get();
		}
		else {
			return null;
		}
		
	}
	
	public Movie updateMovie(String id, Movie movie) {
		Optional<Movie> m = this.movieRepository.findById(id);
		
		m.get().setBudget(movie.getBudget());
		m.get().setRuntime(movie.getRuntime());
		m.get().setLanguage(movie.getLanguage());
		m.get().setRelease(movie.getRelease());
		
		return this.movieRepository.save(m.get());
	}

	
}
