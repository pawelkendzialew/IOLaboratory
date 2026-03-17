package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.GameDao;
import vod.model.Platform;
import vod.model.Studio;
import vod.model.Game;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemGameDao implements GameDao {
    @Override
    public List<Game> findAll() {
        return SampleData.games;
    }

    @Override
    public Game findById(int id) {
        return SampleData.games.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Game> findByStudio(Studio s) { // Zmieniona nazwa
        // Zmienione g.getDirector() na g.getStudio()
        return SampleData.games.stream().filter(g -> g.getStudio() == s).collect(Collectors.toList());
    }

    @Override
    public List<Game> findByPlatform(Platform p) { // Zmieniona nazwa
        // Zmienione g.getCinemas() na g.getPlatforms()
        return SampleData.games.stream().filter(g -> g.getPlatforms().contains(p)).collect(Collectors.toList());
    }

    @Override
    public Game add(Game g) {
        int max = SampleData.games.stream().max((g1, g2) -> g1.getId() - g2.getId()).get().getId();
        g.setId(++max);
        SampleData.games.add(g);
        return g;
    }
}