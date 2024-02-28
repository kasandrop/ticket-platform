package com.moviemicroservice.controller;

import com.uwetrottmann.tmdb2.Tmdb;
import com.uwetrottmann.tmdb2.entities.*;
import com.uwetrottmann.tmdb2.enumerations.MediaType;
import com.uwetrottmann.tmdb2.enumerations.TimeWindow;
import com.uwetrottmann.tmdb2.services.MoviesService;
import com.uwetrottmann.tmdb2.services.SearchService;
import com.uwetrottmann.tmdb2.services.TrendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/movie")
public class MovieController {

    private static final String API_KEY = "4a4102dde36a1fc2260cdd84a4c2da28";

    private static final Tmdb tmdb = new Tmdb(API_KEY);

    private MoviesService moviesService;
    private SearchService searchService;
    private TrendingService trendingService;

    public MovieController() {
        this.moviesService = tmdb.moviesService();
        this.searchService = tmdb.searchService();
        this.trendingService = tmdb.trendingService();
    }

    @GetMapping("/search")
    ResponseEntity<List<BaseMovie>> search(@RequestParam() String search) {
        try {
            Response<MovieResultsPage> response = searchService
                    .movie(search, 1, "en-US", "", false, null, null)
                    .execute();
            if (response.isSuccessful()) {
                MovieResultsPage movies = response.body();
                return ResponseEntity.ok().body(movies.results);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("")
    ResponseEntity<Movie> details(@RequestParam() int movie_id) {
        try {
            Response<Movie> response = moviesService
                    .summary(movie_id, "en-Us")
                    .execute();
            if (response.isSuccessful()) {
                Movie movie = response.body();
                return ResponseEntity.ok().body(movie);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/reviews")
    ResponseEntity<List<Review>> reviews(@RequestParam() int movie_id) {
        try {
            Response<ReviewResultsPage> response = moviesService
                    .reviews(movie_id, 1, "en-Us")
                    .execute();
            if (response.isSuccessful()) {
                ReviewResultsPage reviewResultsPage = response.body();
                return ResponseEntity.ok().body(reviewResultsPage.results);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/cast")
    ResponseEntity<List<CastMember>> cast(@RequestParam() int movie_id) {
        try {
            Response<Credits> response = moviesService
                    .credits(movie_id)
                    .execute();
            if (response.isSuccessful()) {
                Credits credits = response.body();
                return ResponseEntity.ok().body(credits.cast);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/release")
    ResponseEntity<List<ReleaseDatesResult>> release(@RequestParam() int movie_id) {
        try {
            Response<ReleaseDatesResults> response = moviesService
                    .releaseDates(movie_id)
                    .execute();
            if (response.isSuccessful()) {
                ReleaseDatesResults releaseDatesResults = response.body();
                return ResponseEntity.ok().body(releaseDatesResults.results);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @PostMapping("/addRating")
    ResponseEntity<List<Review>> rate(@RequestParam() int id) {
        try {
            Response<ReviewResultsPage> response = moviesService
                    .reviews(id, 1, "en-Us")
                    .execute();
            if (response.isSuccessful()) {
                ReviewResultsPage reviewResultsPage = response.body();
                return ResponseEntity.ok().body(reviewResultsPage.results);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/trending/day")
    ResponseEntity<List<Trending>> trendingToday() {
        try {
            Response<TrendingResultsPage> response = trendingService
                    .trending(MediaType.MOVIE, TimeWindow.DAY)
                    .execute();
            if (response.isSuccessful()) {
                TrendingResultsPage trendingResultsPage = response.body();
                return ResponseEntity.ok().body(trendingResultsPage.results);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @GetMapping("/trending/week")
    ResponseEntity<List<Trending>> trendingWeek() {
        try {
            Response<TrendingResultsPage> response = trendingService
                    .trending(MediaType.MOVIE, TimeWindow.WEEK)
                    .execute();
            if (response.isSuccessful()) {
                TrendingResultsPage trendingResultsPage = response.body();
                return ResponseEntity.ok().body(trendingResultsPage.results);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

}
