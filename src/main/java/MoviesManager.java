public class MoviesManager {
    private int LimitShowFilm = 5;
    private MoviePoster[] movies = new MoviePoster[0];

    public MoviesManager() {
    }

    public MoviesManager(int LimitShowFilm) {
        this.LimitShowFilm = LimitShowFilm;
    }

    public int getLimitManager() {
        return LimitShowFilm;
    }


    public void addMovie(MoviePoster movie) {
        MoviePoster[] tmp = new MoviePoster[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MoviePoster[] findAll() {
        return movies;
    }

    public MoviePoster[] findLast() {
        int resultLenght;
        if (movies.length < LimitShowFilm) {
            resultLenght = movies.length;
        } else {
            resultLenght = LimitShowFilm;
        }
        MoviePoster[] tmp = new MoviePoster[resultLenght];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;

    }
}
