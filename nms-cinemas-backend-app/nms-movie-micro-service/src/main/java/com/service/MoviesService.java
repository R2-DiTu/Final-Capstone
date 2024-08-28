package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.movies;
import com.repository.MoviesRepository;

@Service
public class MoviesService {

	@Autowired
	MoviesRepository moviesRepository;
	
	public List<movies> findAllMovies(){
		return moviesRepository.findAll();
	}

	public String storeMovie(List<movies> listOfMovies) {
		moviesRepository.saveAll(listOfMovies);
		return "Record Stored. :D";
	}

public long getMoviesCount() {
	return moviesRepository.count();
}

public String addMovie(movies movies) {
	Optional<movies> result = moviesRepository.findById(movies.getMid());
		if(result.isPresent()) {
			return "Movie already present with id as "+movies.getMid();
		}else {
			moviesRepository.save(movies);
			return "Movie record stored successfully";
		}
	}

}

