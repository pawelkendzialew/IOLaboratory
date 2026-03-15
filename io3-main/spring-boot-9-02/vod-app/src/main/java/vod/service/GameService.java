package vod.service;

import vod.model.Studio;
import vod.model.Game;

import java.util.List;

public interface GameService {


    List<Game> getAllMovies();

    List<Game> getMoviesByDirector(Studio d);

    Game getMovieById(int id);

    Game addMovie(Game m);


    List<Studio> getAllDirectors();

    Studio getDirectorById(int id);

    Studio addDirector(Studio d);
}
