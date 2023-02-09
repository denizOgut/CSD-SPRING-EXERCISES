package com.denizogut.movie.data.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {
    public long movieId;

    public String name;
    public LocalDate sceneDate;
    public long rating;
    public double cost;
    public double imdb;

    public Movie(long movieId, String name, LocalDate sceneDate, long rating, double cost, double imdb)
    {
        this.movieId = movieId;
        this.name = name;
        this.sceneDate = sceneDate;
        this.rating = rating;
        this.cost = cost;
        this.imdb = imdb;
    }

    public long getMovieId()
    {
        return movieId;
    }

    public void setMovieId(long movieId)
    {
        this.movieId = movieId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getSceneDate()
    {
        return sceneDate;
    }

    public void setSceneDate(LocalDate sceneDate)
    {
        this.sceneDate = sceneDate;
    }

    public long getRating()
    {
        return rating;
    }

    public void setRating(long rating)
    {
        this.rating = rating;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public double getImdb()
    {
        return imdb;
    }

    public void setImdb(double imdb)
    {
        this.imdb = imdb;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Movie m && m.movieId == movieId;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(movieId, name, sceneDate, rating, cost, imdb);
    }
}
