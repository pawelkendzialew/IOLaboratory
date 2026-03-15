package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import vod.model.Platform;
import vod.model.Game;
import vod.repository.PlatformDao;
import vod.repository.GameDao;
import vod.service.PlatformService;

import java.util.List;
import java.util.logging.Logger;

@Component
@Scope("prototype")
public class PlatformServiceBean implements PlatformService {

    private static final Logger log = Logger.getLogger(PlatformService.class.getName());

    private PlatformDao platformDao;
    private GameDao gameDao;

    public PlatformServiceBean(PlatformDao platformDao, GameDao gameDao) {
        log.info("creating cinema service bean");
        this.platformDao = platformDao;
        this.gameDao = gameDao;
    }

    @Override
    public Platform getCinemaById(int id) {
        log.info("searching cinema by id " + id);
        return platformDao.findById(id);
    }

    @Override
    public List<Game> getMoviesInCinema(Platform c) {
        log.info("searching movies played in cinema " + c.getId());
        return gameDao.findByCinema(c);
    }

    @Override
    public List<Platform> getAllCinemas() {
        log.info("searching all cinemas");
        return platformDao.findAll();
    }

    @Override
    public List<Platform> getCinemasByMovie(Game m) {
        log.info("searching cinemas by movie " + m.getId());
        return platformDao.findByMovie(m);
    }

}
