package com;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entity.movies;
//import com.repository.MoviesRepository;
import com.service.MoviesService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication (scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
@EnableDiscoveryClient
public class NmsMoviesMSApplication {
	
	@Autowired
	MoviesService moviesService;
	
	@PostConstruct
	public void init() {
		long count= moviesService.getMoviesCount();
		if(count==0) {
			List<movies> listOfMovies = Arrays.asList(
					new movies(1, "Terminator 3", "Spanish", 18, 2, "10/10/2024"), 
					new movies(2, "Dragon Ball Z: Battle of the Gods", "Japanese", 15, 3, "10/25/2024"), 
					new movies(3, "Deadpool and Wolverine", "Esperanto", 16, 2, "02/14/2025")
					);
			moviesService.storeMovie(listOfMovies);
			System.out.println("Movies Record Stored...");
	}else {
		System.out.println("Record Already Present");
	}
}

	public static void main(String[] args) {
		SpringApplication.run(NmsMoviesMSApplication.class, args);
	}

}
