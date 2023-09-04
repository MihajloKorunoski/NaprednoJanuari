package mk.ukim.finki.napredno.exercises.ispitni.movierating;

import java.util.List;

class Movie {
    private String name;
    private List<Integer> ratings;
    private double AverageRating;

    public Movie(String name, List<Integer> ratings) {
        this.name = name;
        this.ratings = ratings;
        AverageRating = ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public double getAverageRating() {
        return AverageRating;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f) of %d ratings", getName(), getAverageRating(), ratings.size());
    }
}
