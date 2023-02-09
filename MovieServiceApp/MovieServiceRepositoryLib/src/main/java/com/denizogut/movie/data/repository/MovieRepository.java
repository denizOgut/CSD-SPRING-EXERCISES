package com.denizogut.movie.data.repository;

import com.denizogut.movie.data.BeanName;
import com.denizogut.movie.data.entity.DirectorWithFullName;
import com.denizogut.movie.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.*;

@Repository(BeanName.MOVIE_REPOSITORY)
public class MovieRepository implements IMovieRepository {

    private static final String COUNT_SQL = "SELECT COUNT(*) FROM movies";


    private static final String FIND_BY_ID_SQL = "SELECT * FROM movies WHERE movie_id = :movieId";

    private static final String FIND_BY_MONTH_AND_YEAR_SQL = "SELECT * FROM movies WHERE date_part('month', scene_date) = :month and date_part('year', scene_date) = :year";

    private static final String FIND_BY_YEAR_BETWEEN_SQL = "SELECT * FROM movies WHERE date_part('year', scene_date) = :begin and date_part('year', scene_date) = :end";
    private static final String FIND_BY_YEAR_SQL = "SELECT * FROM movies WHERE date_part('year', scene_date) = :year";

    private static final String FIND_BY_MONTH_SQL = "SELECT * FROM movies WHERE date_part('month', scene_date) = :month";
    private static final String SAVE_SQL = "INSERT INTO movies (movie_id, name, scene_date, rating, cost, imdb) VALUES (:movieId, :name, :sceneDate, :rating,:cost,:imdb)";

    private static final String MOVIES_OF_DIRECTOR_SQL = "SELECT movies.movie_id, name, scene_date, rating, cost, imdb FROM movies  inner join movies_to_director mtd on movies.movie_id = mtd.movie_id inner join directors d on d.director_id = mtd.director_id where d.director_id = :directorId";

    private final NamedParameterJdbcTemplate namedParamJdbcTemp;


    private static Movie getMovie(ResultSet rs) throws SQLException
    {
        var movieId = rs.getLong("movie_id");
        var name = rs.getString("name");
        var rating = rs.getLong("rating");
        var cost = rs.getDouble("cost");
        var imdb = rs.getDouble("imdb");
        var sceneDate = rs.getDate("scene_date").toLocalDate();
        return new Movie(movieId, name, sceneDate, rating, cost, imdb);
    }

    private static void fillMovies(List<Movie> movies, ResultSet rs) throws SQLException
    {
        do {
            movies.add(getMovie(rs));
        } while (rs.next());
    }

    public MovieRepository(NamedParameterJdbcTemplate namedParamJdbcTemp)
    {
        this.namedParamJdbcTemp = namedParamJdbcTemp;
    }


    @Override
    public Iterable<Movie> findByMonthAndYear(int month, int year)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();
        paramMap.put("month", month);
        paramMap.put("year", year);

        namedParamJdbcTemp.query(FIND_BY_MONTH_AND_YEAR_SQL, paramMap, (ResultSet rs) -> fillMovies(movies, rs));
        return movies;
    }

    @Override
    public Iterable<Movie> findByYearBetween(int begin, int end)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("begin", begin);
        paramMap.put("end", end);

        namedParamJdbcTemp.query(FIND_BY_YEAR_BETWEEN_SQL, paramMap, (ResultSet rs) -> fillMovies(movies, rs));

        return movies;
    }

    @Override
    public Iterable<Movie> findByMonth(int month)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("month", month);

        namedParamJdbcTemp.query(FIND_BY_MONTH_SQL, paramMap, (ResultSet rs) -> fillMovies(movies, rs));

        return movies;
    }

    @Override
    public Iterable<Movie> findByYear(int year)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("year", year);

        namedParamJdbcTemp.query(FIND_BY_YEAR_SQL, paramMap, (ResultSet rs) -> fillMovies(movies, rs));

        return movies;
    }

    @Override
    public Iterable<Movie> findMoviesOfDirector(long directorId)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();
        paramMap.put("directorId", directorId);
        namedParamJdbcTemp.query(MOVIES_OF_DIRECTOR_SQL,paramMap,(ResultSet rs) -> fillMovies(movies,rs));
        return  movies;
    }

    @Override
    public <S extends Movie> S save(S entity)
    {
        var param = new BeanPropertySqlParameterSource(entity);
        param.registerSqlType("sceneDate", Types.DATE);
        namedParamJdbcTemp.update(SAVE_SQL, param);
        return entity;
    }

    @Override
    public <S extends Movie> Iterable<S> saveAll(Iterable<S> entities)
    {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong)
    {
        var paramMap = new HashMap<String, Object>();
        var movies = new ArrayList<Movie>();

        paramMap.put("movieId", aLong);

        namedParamJdbcTemp.query(FIND_BY_ID_SQL, paramMap, (ResultSet rs) -> fillMovies(movies, rs));
        return movies.isEmpty() ? Optional.empty() : Optional.of(movies.get(0));
    }

    @Override
    public boolean existsById(Long aLong)
    {
        return false;
    }

    @Override
    public Iterable<Movie> findAll()
    {
        return null;
    }

    @Override
    public Iterable<Movie> findAllById(Iterable<Long> longs)
    {
        return null;
    }

    @Override
    public long count()
    {
        var count = new ArrayList<Long>();
        namedParamJdbcTemp.query(COUNT_SQL, rs ->
        {
            count.add(rs.getLong(1));
        });

        return count.get(0);
    }

    @Override
    public void deleteById(Long aLong)
    {
        // TODO document why this method is empty
    }

    @Override
    public void delete(Movie entity)
    {
        // TODO document why this method is empty
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs)
    {
        // TODO document why this method is empty
    }

    @Override
    public void deleteAll(Iterable<? extends Movie> entities)
    {
        // TODO document why this method is empty
    }

    @Override
    public void deleteAll()
    {
        // TODO document why this method is empty
    }
}
