package vod.service;

import vod.model.Platform;
import vod.model.Game;

import java.util.List;

public interface PlatformService {
//api zwraca nam wszystkie kina
    Platform getPlatformById(int id);

    List<Platform> getAllPlatforms();

    List<Platform> getPlatformsByGame(Game m);

    List<Game> getGamesInPlatform(Platform c);

    Platform addPlatform(Platform platform);
}
