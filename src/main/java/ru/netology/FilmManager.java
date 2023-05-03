package ru.netology;

public class FilmManager {
    private int limit;
    private String[] films;

    public FilmManager() {
        this.limit = 5;
        this.films = new String[0];
    }

    public FilmManager(int limit) {
        this.limit = limit;
        this.films = new String[0];
    }

    public void addFilm(String film) {
        String[] newFilms = new String[this.films.length + 1];
        System.arraycopy(this.films, 0, newFilms, 0, this.films.length);
        newFilms[newFilms.length - 1] = film;
        this.films = newFilms;
    }

    public String[] findAll() {
        return this.films;
    }

    public String[] findLast() {
        int resultLength;
        if (this.films.length > this.limit) {
            resultLength = this.limit;
        } else {
            resultLength = this.films.length;
        }
        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = this.films[this.films.length - 1 - i];
        }
        return result;
    }
}
