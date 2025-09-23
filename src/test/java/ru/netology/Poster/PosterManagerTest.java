package ru.netology.Poster;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    @Test
    void addMovie() {
        PosterManager manager = new PosterManager();
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        manager.add(movie1);
        manager.add(movie2);

        Movie[] expected = {movie1, movie2};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllMovies() {
        PosterManager manager = new PosterManager();
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        manager.add(movie1);
        manager.add(movie2);

        Movie[] expected = {movie1, movie2};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastDefaultLimit() {
        PosterManager manager = new PosterManager();
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        Movie movie4 = new Movie("Movie 4");
        Movie movie5 = new Movie("Movie 5");
        Movie movie6 = new Movie("Movie 6");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        Movie[] expected = {movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastCustomLimit() {
        PosterManager manager = new PosterManager(3);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        Movie movie4 = new Movie("Movie 4");
        Movie movie5 = new Movie("Movie 5");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        Movie[] expected = {movie5, movie4, movie3};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastLessThanLimit() {
        PosterManager manager = new PosterManager(7);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastEmpty() {
        PosterManager manager = new PosterManager();
        Movie[] expected = {};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllEmpty() {
        PosterManager manager = new PosterManager();
        Movie[] expected = {};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastLimitEqualsMoviesLength() {
        PosterManager manager = new PosterManager(3);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastZeroLimit() {
        PosterManager manager = new PosterManager(0);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        manager.add(movie1);
        manager.add(movie2);

        Movie[] expected = {};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void testMovieGetterSetter() {
        Movie movie = new Movie("Original Name");
        movie.setName("New Name");
        assertEquals("New Name", movie.getName());
    }

    @Test
    void testDefaultConstructor() {
        PosterManager manager = new PosterManager();
        // Просто создаем объект, чтобы покрыть конструктор по умолчанию.
        assertNotNull(manager);
    }

    @Test
    void testCustomConstructor() {
        PosterManager manager = new PosterManager(10);
        // Просто создаем объект, чтобы покрыть конструктор с параметром.
        assertNotNull(manager);
    }

    //Добавляем тест, когда фильмов ровно столько, сколько лимит
    @Test
    void findLastMoviesEqualToLimit() {
        PosterManager manager = new PosterManager(3);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    //Добавляем тест, когда фильмов больше, чем лимит (но лимит не дефолтный)
    @Test
    void findLastMoviesMoreThanLimitCustom() {
        PosterManager manager = new PosterManager(2);
        Movie movie1 = new Movie("Movie 1");
        Movie movie2 = new Movie("Movie 2");
        Movie movie3 = new Movie("Movie 3");
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] expected = {movie3, movie2};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }
}
