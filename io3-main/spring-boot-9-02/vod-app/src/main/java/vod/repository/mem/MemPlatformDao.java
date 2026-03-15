package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vod.repository.PlatformDao;
import vod.model.Platform;
import vod.model.Game;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Primary
public class MemPlatformDao implements PlatformDao {

    @Override
    public List<Platform> findAll() {
        return SampleData.platforms;
    }

    @Override
    public Platform findById(int id) {
        return SampleData.platforms.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Platform> findByGame(Game m) {
        return SampleData.platforms.stream().filter(c -> c.getGames().contains(m)).collect(Collectors.toList());
    }
}
