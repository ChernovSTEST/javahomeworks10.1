package ru.netology;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmManagerTest {

    @Test
    public void testAddFilm() {
        FilmManager manager = new FilmManager();
        manager.addFilm("Film 1");
        assertArrayEquals(new String[]{"Film 1"}, manager.findAll());

        manager.addFilm("Film 2");
        assertArrayEquals(new String[]{"Film 1", "Film 2"}, manager.findAll());

        manager.addFilm("Film 3");
        assertArrayEquals(new String[]{"Film 1", "Film 2", "Film 3"}, manager.findAll());
    }

    @Test
    public void testFindAll() {
        FilmManager manager = new FilmManager();
        assertArrayEquals(new String[0], manager.findAll());

        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        assertArrayEquals(new String[]{"Film 1", "Film 2"}, manager.findAll());
    }

    @Test
    public void testFindLast() {
        FilmManager manager = new FilmManager(2);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        manager.addFilm("Film 3");

        assertArrayEquals(new String[]{"Film 3", "Film 2"}, manager.findLast());

        manager = new FilmManager();
        manager.addFilm("Film 1");
        assertArrayEquals(new String[]{"Film 1"}, manager.findLast());

        manager = new FilmManager(1);
        manager.addFilm("Film 1");
        manager.addFilm("Film 2");
        assertArrayEquals(new String[]{"Film 2"}, manager.findLast());
    }
}

