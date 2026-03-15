package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.Platform;
import vod.model.Game;
import vod.repository.PlatformDao;


import java.util.List;
@Component
public class DummyPlatformDao implements PlatformDao {
    @Override
    public List<Platform> findAll() {return List.of();}
    @Override
    public Platform findById(int id) {return null;}
    @Override
    public List<Platform> findByGame(Game m) {return List.of();}
}
