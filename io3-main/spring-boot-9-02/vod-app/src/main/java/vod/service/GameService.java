package vod.service;

import vod.model.Studio;
import vod.model.Game;

import java.util.List;

public interface GameService {


    List<Game> getAllGames();

    List<Game> getGamesByStudio(Studio d);

    Game getGameById(int id);

    Game addGame(Game m);


    List<Studio> getAllStudios();

    Studio getStudioById(int id);

    Studio addStudio(Studio d);
}
