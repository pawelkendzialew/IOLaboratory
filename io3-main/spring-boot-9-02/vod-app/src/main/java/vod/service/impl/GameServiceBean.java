package vod.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vod.repository.PlatformDao;
import vod.repository.StudioDao;
import vod.repository.GameDao;
import vod.model.Platform;
import vod.model.Studio;
import vod.model.Game;
import vod.service.GameService;

import java.util.List;
import java.util.logging.Logger;

@Component
public class GameServiceBean implements GameService {

    private static final Logger log = Logger.getLogger(GameService.class.getName());



    private StudioDao studioDao;
    private PlatformDao platformDao;
    private GameDao gameDao;

    public GameServiceBean(StudioDao studioDao, PlatformDao platformDao, GameDao gameDao) {
        this.studioDao = studioDao;
        this.platformDao = platformDao;
        this.gameDao = gameDao;
    }
    @Autowired
    public void setStudioDao(StudioDao studioDao) {
        this.studioDao = studioDao;
    }
    public List<Game> getAllGames() {
        log.info("searching all games...");
        return gameDao.findAll();
    }

    public List<Game> getGamesByStudio(Studio d) {
        log.info("serching games by studio " + d.getId());
        return gameDao.findByStudio(d);
    }

    public List<Game> getGamesInPlatform(Platform c) {
        log.info("searching games in platform " + c.getId());
        return gameDao.findByPlatform(c);
    }

    public Game getGameById(int id) {
        log.info("searching game by id " + id);
        return gameDao.findById(id);
    }
/*
    public List<Platform> getAllGames() {
        log.info("searching all games");
        return platformDao.findAll();
    }*/

    public List<Platform> getPlatformsByGame(Game m) {
        log.info("searching platforms by game " + m.getId());
        return platformDao.findByGame(m);
    }

    public Platform getPlatformsById(int id) {
        log.info("searching platform by id " + id);
        return platformDao.findById(id);
    }

    public List<Studio> getAllStudios() {
        log.info("searching all studios");
        return studioDao.findAll();
    }

    public Studio getStudioById(int id) {
        log.info("searching studio by id " + id);
        return studioDao.findById(id);
    }

    @Override
    public Game addGame(Game m) {
        log.info("about to add game " + m);
        return gameDao.add(m);
    }

    @Override
    public Studio addStudio(Studio d) {
        log.info("about to add studio " + d);
        return studioDao.add(d);
    }

}
