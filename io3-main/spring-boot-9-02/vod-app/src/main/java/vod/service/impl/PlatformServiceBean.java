package vod.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Platform;
import vod.model.Game;
import vod.repository.PlatformDao;
import vod.repository.GameDao;
import vod.service.PlatformService;

import java.util.List;
import java.util.logging.Logger;

@Service
@Scope("prototype")
public class PlatformServiceBean implements PlatformService {

    private static final Logger log = Logger.getLogger(PlatformService.class.getName());

    private PlatformDao platformDao;
    private GameDao gameDao;

    public PlatformServiceBean(PlatformDao platformDao, GameDao gameDao) {
        log.info("creating platform service bean");
        this.platformDao = platformDao;
        this.gameDao = gameDao;
    }

    @Override
    public Platform getPlatformById(int id) {
        log.info("searching platform by id " + id);
        return platformDao.findById(id);
    }

    @Override
    public List<Game> getGamesInPlatform(Platform c) {
        log.info("searching games played in platforms " + c.getId());
        return gameDao.findByPlatform(c);
    }

    @Override
    public List<Platform> getAllPlatforms() {
        log.info("searching all platforms");
        return platformDao.findAll();
    }

    @Override
    public List<Platform> getPlatformsByGame(Game m) {
        log.info("searching platform by game " + m.getId());
        return platformDao.findByGame(m);
    }
    @Override
    public Platform addPlatform(Platform platform) {
        log.info("about to add platform " + platform.getName());
        return platformDao.add(platform);
    }

}
