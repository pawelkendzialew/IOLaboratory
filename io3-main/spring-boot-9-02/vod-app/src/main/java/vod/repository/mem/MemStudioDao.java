package vod.repository.mem;

import org.springframework.stereotype.Component;
import vod.repository.StudioDao;
import vod.model.Studio;

import java.util.List;

@Component
public class MemStudioDao implements StudioDao {
    @Override
    public List<Studio> findAll() {
        return SampleData.studios;
    }

    @Override
    public Studio findById(int id) {
        return SampleData.studios.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Studio add(Studio d) {
        int max = SampleData.studios.stream().max((d1, d2) -> d1.getId() - d2.getId()).get().getId();
        d.setId(++max);
        SampleData.studios.add(d);
        return d;
    }
}
