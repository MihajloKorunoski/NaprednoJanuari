package mk.ukim.finki.napredno.exercises.ispitni.movierating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class MoviesList {
    List<Movie> movies;

    public MoviesList() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, int[] ratings) {
        movies.add(new Movie(title, Arrays.stream(ratings).boxed().collect(Collectors.toList())));
    }

    public List<Movie> top10ByAvgRating() {
        return movies.stream()
                .sorted(Comparator.comparing(Movie::getAverageRating)
                        .reversed()
                        .thenComparing(Movie::getName))
                .limit(10)
                .collect(Collectors.toList());
    }

    public List<Movie> top10ByRatingCoef() {
        int maxRatings = movies.stream().mapToInt(movie -> movie.getRatings().size()).max().orElse(1);
        return movies.stream()
                .sorted(Comparator.comparingDouble((Movie movie) -> movie.getAverageRating() * movie.getRatings().size() / maxRatings)
                        .reversed()
                        .thenComparing(Movie::getName))
                .limit(10)
                .collect(Collectors.toList());
    }
}
