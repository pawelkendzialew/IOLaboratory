package vod;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vod.model.Platform;
import vod.service.PlatformService;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class VodComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final PlatformService platformService;

    public VodComponent(PlatformService platformService) {this.platformService = platformService;}
    @PostConstruct
    void init(){
        log.info("in post construct. ");}
     @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
     }

     @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Platform> platforms = platformService.getAllPlatforms();
        log.info("{} platform found.", platforms.size());
     platforms.forEach(platform->log.info("{}", platform));
    }

}
