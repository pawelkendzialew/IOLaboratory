package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.PlatformDao;
import vod.model.Platform;
import vod.model.Game;

import java.util.List;
import java.util.stream.Collectors;

@Repository("platformDao")
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

    @Override
    public Platform add(Platform p) {
        int max = SampleData.platforms.stream().max((p1, p2) -> p1.getId() - p2.getId()).get().getId();
        p.setId(++max);
        SampleData.platforms.add(p);
        return p;
    }
}
