package vod.repository;

import vod.model.Platform;
import vod.model.Studio;
import vod.model.Game;

import java.util.List;

public interface GameDao {

    List<Game> findAll();

    Game findById(int id);

    List<Game> findByDirector(Studio d);

    List<Game> findByCinema(Platform c);

    Game add(Game m);

}
