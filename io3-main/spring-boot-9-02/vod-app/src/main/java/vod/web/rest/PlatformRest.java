package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.Platform;
import vod.service.PlatformService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PlatformRest {

    private final PlatformService platformService;

    @GetMapping("/platforms") // Zmieniliśmy ścieżkę z /cinemas na /platforms
    List<Platform> getPlatforms() {
        log.info("about to retrieve platforms list");
        List<Platform> platforms = platformService.getAllPlatforms();
        log.info("{} platforms found.", platforms.size());
        return platforms;
    }
}