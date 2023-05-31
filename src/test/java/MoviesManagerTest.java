import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieManagerTest {

    MoviesManager manager = new MoviesManager();
    MoviesManager manager2 = new MoviesManager(3);

    MoviePoster movie1 = new MoviePoster(1, "Бладшот", "боевик");
    MoviePoster movie2 = new MoviePoster(2, "Вперёд", "мультфильм");
    MoviePoster movie3 = new MoviePoster(3, "Отель \"Белград\"", "комедия");
    MoviePoster movie4 = new MoviePoster(4, "Джентельмены", "боевик");
    MoviePoster movie5 = new MoviePoster(5, "Человек-невидимка", "ужасы");
    MoviePoster movie6 = new MoviePoster(6, "Тролли. Мировой тур", "мультфильм");
    MoviePoster movie7 = new MoviePoster(7, "Номер один", "комедия");

    @BeforeEach
    public void instalPoster() {
        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);
    }

    @Test
    public void testLimitManagerTest() {

        Assertions.assertEquals(5, manager.getLimitManager());
    }

    @Test
    public void testLimitManagerIf3Test() {

        manager2.addMovie(movie1);
        manager2.addMovie(movie2);
        manager2.addMovie(movie3);

        Assertions.assertEquals(3, manager2.getLimitManager());
    }

    @Test
    public void addNewMovieTest() {

        MoviePoster[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        MoviePoster[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastTest() {

        MoviePoster[] expected = {movie7, movie6, movie5, movie4, movie3};
        MoviePoster[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfMoviesLessManagerTest() {

        manager2.addMovie(movie1);
        manager2.addMovie(movie2);

        MoviePoster[] expected = {movie2, movie1};
        MoviePoster[] actual = manager2.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastIfMoviesEqualsManagerTest() {

        manager2.addMovie(movie1);
        manager2.addMovie(movie2);
        manager2.addMovie(movie3);

        MoviePoster[] expected = {movie3, movie2, movie1};
        MoviePoster[] actual = manager2.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}