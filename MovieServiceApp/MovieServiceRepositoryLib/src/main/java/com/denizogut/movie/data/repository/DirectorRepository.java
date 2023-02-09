package com.denizogut.movie.data.repository;

import com.denizogut.movie.data.BeanName;
import com.denizogut.movie.data.entity.Director;
import com.denizogut.movie.data.entity.DirectorWithFullName;
import com.denizogut.movie.data.entity.Movie;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository(BeanName.DIRECTOR_REPOSITORY)
public class DirectorRepository implements IDirectorRepository {


    private static final String COUNT_SQL = "SELECT COUNT(*) FROM directors";


    private static final String FIND_BY_ID_SQL = "SELECT * FROM directors WHERE director_id = :longs";

    private static final String FIND_BY_FIRST_NAME_SQL = "SELECT * FROM directors WHERE first_name = :firstName";

    private static final String SAVE_SQL = "INSERT INTO directors (director_id, first_name, middle_name, family_name, birth_date) VALUES (:directorId, :firstName,:middleName,:familyName,:birthDate)";

    private static final String FIND_BY_YEAR_BETWEEN_SQL = "SELECT director_id,concat(first_name, ' ', COALESCE(middle_name, ''), ' ', last_name) as full_name,birth_date\n" +
            "FROM employees WHERE date_part('year', birth_date) = :begin and date_part('year', birth_date) = :end";

    private static final String DIRECTORS_OF_MOVIE_SQL = "SELECT directors.director_id, directors.first_name,directors.middle_name ,directors.family_name , directors.birth_date FROM  directors inner join movies_to_director mtd on directors.director_id = mtd.director_id inner join movies m on m.movie_id = mtd.movie_id WHERE m.movie_id = :movieId";
    private final NamedParameterJdbcTemplate namedParamJdbcTemp;

    public DirectorRepository(NamedParameterJdbcTemplate namedParamJdbcTemp)
    {
        this.namedParamJdbcTemp = namedParamJdbcTemp;
    }


    private static Director getDirector(ResultSet rs) throws SQLException
    {
        var directorId = rs.getLong("director_id");
        var firstName = rs.getString("first_name");
        var middleName = rs.getString("middle_name");
        var familyName = rs.getString("family_name");
        var birthDate = rs.getDate("birth_date").toLocalDate();

        return new Director(directorId, firstName, Optional.ofNullable(middleName), familyName, birthDate);
    }

    public static DirectorWithFullName getDirectorWithFullName(ResultSet rs) throws SQLException
    {
        var directorId = rs.getLong("director_id");
        var fullName = rs.getString("full_name");
        var birthDate = rs.getDate("birth_date").toLocalDate();
        return  new DirectorWithFullName(directorId,fullName,birthDate);
    }

    private static void fillDirectors(List<Director> directors, ResultSet rs) throws SQLException
    {
        do {
            directors.add(getDirector(rs));
        } while (rs.next());
    }

    private static void fillDirectorsWithFullName(List<DirectorWithFullName> directors, ResultSet rs) throws SQLException
    {
        do {
            directors.add(getDirectorWithFullName(rs));
        } while (rs.next());
    }

    @Override
    public Iterable<Director> findByFirstName(String firstName)
    {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<Director>();

        paramMap.put("firstName", firstName);
        namedParamJdbcTemp.query(FIND_BY_FIRST_NAME_SQL, paramMap, (ResultSet rs) -> fillDirectors(directors, rs));
        return directors;
    }

    @Override
    public Iterable<DirectorWithFullName> findByBirthDateBetween(int begin, int end)
    {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<DirectorWithFullName>();

        paramMap.put("begin", begin);
        paramMap.put("end", end);
        namedParamJdbcTemp.query(FIND_BY_YEAR_BETWEEN_SQL,paramMap, (ResultSet rs) -> fillDirectorsWithFullName(directors,rs));

        return  directors;
    }

    @Override
    public Iterable<DirectorWithFullName> findDirectorsOfMovie(long movieId)
    {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<DirectorWithFullName>();
        paramMap.put("movieId", movieId);
        namedParamJdbcTemp.query(DIRECTORS_OF_MOVIE_SQL,paramMap,(ResultSet rs) -> fillDirectorsWithFullName(directors,rs));
        return  directors;
    }


    @Override
    public <S extends Director> S save(S entity)
    {
        var param = new BeanPropertySqlParameterSource(entity);
        param.registerSqlType("birthDate", Types.DATE);
        namedParamJdbcTemp.update(SAVE_SQL, param);
        return entity;
    }

    @Override
    public <S extends Director> Iterable<S> saveAll(Iterable<S> entities)
    {
        return null;
    }

    @Override
    public Optional<Director> findById(Long aLong)
    {

        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<Director>();

        paramMap.put("longs", aLong);
        namedParamJdbcTemp.query(FIND_BY_ID_SQL, paramMap, (ResultSet rs) -> fillDirectors(directors, rs));
        return directors.isEmpty() ? Optional.empty() : Optional.of(directors.get(0));
    }

    @Override
    public boolean existsById(Long aLong)
    {
        return false;
    }

    @Override
    public Iterable<Director> findAll()
    {
        return null;
    }

    @Override
    public Iterable<Director> findAllById(Iterable<Long> longs)
    {
        var paramMap = new HashMap<String, Object>();
        var directors = new ArrayList<Director>();

        paramMap.put("longs", longs);
        namedParamJdbcTemp.query(FIND_BY_ID_SQL, paramMap, (ResultSet rs) -> fillDirectors(directors, rs));
        return directors;
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
    public void delete(Director entity)
    {
        // TODO document why this method is empty
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs)
    {
        // TODO document why this method is empty
    }

    @Override
    public void deleteAll(Iterable<? extends Director> entities)
    {
        // TODO document why this method is empty
    }

    @Override
    public void deleteAll()
    {
        // TODO document why this method is empty
    }
}
