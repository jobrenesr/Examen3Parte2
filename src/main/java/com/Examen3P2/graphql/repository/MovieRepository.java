package com.Examen3P2.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Examen3P2.graphql.entity.*;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
	List<Movie> findBytitleContainingIgnoreCase(String idMovie);
}
