package vod.repository;

import vod.model.Platform;
import vod.model.Game;

import java.util.List;

public interface PlatformDao {

    List<Platform> findAll();

    Platform findById(int id);

    List<Platform> findByGame(Game m);

    Platform add(Platform p);

}
