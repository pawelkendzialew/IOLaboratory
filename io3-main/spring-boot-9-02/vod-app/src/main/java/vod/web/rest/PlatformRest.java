package vod.web.rest;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import vod.model.Game;
import vod.model.Platform;
import vod.service.GameService;
import vod.service.PlatformService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class PlatformRest {

    private final PlatformService platformService;
    private final GameService gameService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/platforms") // Zmieniliśmy ścieżkę z /cinemas na /platforms
    List<Platform> getPlatforms(
            @RequestParam(value = "pharse", required = false) String pharse,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false)String someCookie
    ) {
        log.info("about to retrieve platforms list");
        log.info("pharse: {}", pharse);
        log.info("custom header param: {}",customHeader);
        List<Platform> platforms = platformService.getAllPlatforms();
        log.info("{} platforms found.", platforms.size());
        return platforms;
    }

    @GetMapping("/platforms/{id}")
    ResponseEntity<Platform> GetPlatform(@PathVariable ("id") int id) {
        log.info("about to retrieve platform with id {}", id);
        Platform platform = platformService.getPlatformById(id);
        log.info("{} platform found.", platform);
        if (platform != null) {
            return ResponseEntity.status(200).body(platform);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/games/{gameId}/platforms")
    ResponseEntity<List<Platform>> getPlatformsPlayingGame(@PathVariable ("gameId") int gameId) {
    log.info("about to retrieve platforms playing game {}", gameId);
    Game game = gameService.getGameById(gameId);
    if (game == null) {
    return ResponseEntity.notFound().build();}
    else{
        List<Platform> platforms = platformService.getPlatformsByGame(game);
        log.info("there's {} platforms playing game {}", platforms.size(), game.getTitle());
        return ResponseEntity.ok(platforms);
    }
    }

    @PostMapping("/platforms")
    ResponseEntity<?> addPlatform(@Validated @RequestBody Platform platform, Errors errors, HttpServletRequest request) {
        log.info("about to add platform {}", platform);
        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(oe.getCode(), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe)->accu + oe + "\n");

            return ResponseEntity.badRequest().body(errorMessage);
        }
        platform = platformService.addPlatform(platform);
        log.info("{} platform added.", platform);
        return ResponseEntity.status(HttpStatus.CREATED).body(platform);
    }


}