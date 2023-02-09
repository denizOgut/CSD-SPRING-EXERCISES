REST Services
=============

The following REST services are implemented:

-   `POST` service at `~/api/movies/movie/save`: Adds a movie to the database
-   `GET` service at `~/api/movies/movie/count`: Returns the number of movies in the database
-   `GET` service at `~/api/movies/movies/find/sdate/month?m=3`: Returns all movies that were released in the month specified by the `m` parameter
-   `GET` service at `~/api/movies/movie/find/sdate/year?y=2020`: Returns all movies that were released in the year specified by the `y` parameter
-   `GET` service at `~/api/movies/movie/find/sdate/my?month=3&year=2020`: Returns all movies that were released in the month and year specified by the `month` and `year` parameters, respectively
-   `GET` service at `~/api/movies/movie/find/sdate/year/between?begin=2020&end=2022`: Returns all movies that were released between the years specified by the `begin` and `end` parameters
-   `GET` service at `~/api/movies/movie/find/director?id=1`: Returns all movies directed by the director specified by the `id` parameter
-   `GET` service at `~/api/directors/director/find/movie?id=1`: Returns all directors of the movie specified by the `id` parameter
-   `POST` service at `~/api/directors/directors/save`: Adds a director to the database

Notes
-----

-   The database schema for the application is provided and will not be changed
-   Dummy data is provided for development purposes. You may use it if desired
-   JDBC will be used for database operations
-   The name of the database will be `japp1j22_moviesdb`
-   It is recommended to use profiles during development, such as `dev`, `test`, and `default`
-   The database name will be appended with the profile: `japp1j22_moviesdb_dev`, `japp1j22_moviesdb_test`, `japp1j22_moviesdb`
-   If desired, a remote database may be used for the `test` and `prod` profiles, but this is not required
-   Separate services will be developed for `Movie` and `Director`
-   Both of these services will use the same database
-   A separate repository library will be created for database operations
-   A layered architecture is recommended for development
-   Mapstruct and the `MapstructUtil` library can be used for DTO transformations
-   The structure of the DTOs can be determined by the programmer, with the exception of required fields
-   All services will return a response in the following format:



```{
"movies": [
{
"name": "Face Off",
"sceneDate":"1996-05-12"
"cost": "1000000.67"
},
{
"name": "Face Off",
...
}
]
}
```
- Veritabanına göre nullable olan alanlar, tarih zamana ilişkin alanlar vb için format belirlemeleri 
JsonXXX annotation'ları ile yapılabilir