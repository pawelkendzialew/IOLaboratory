package vod.repository.mem;

import vod.model.Platform;
import vod.model.Studio;
import vod.model.Game;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Platform> platforms = new ArrayList<>();
    static List<Studio> studios = new ArrayList<>();
    static List<Game> games = new ArrayList<>();

    static {
        Studio cdProjekt = new Studio(1, "CD Projekt RED", "Poland");
        Studio rockstar = new Studio(2, "Rockstar Games", "USA");
        Studio bethesda = new Studio(3, "Bethesda", "USA");
        Studio fromSoftware = new Studio(4, "FromSoftware", "Japan");

        Game witcher = new Game(1, "The Witcher 3", "url_do_okladki", cdProjekt, 4.9f);
        Game cyberpunk = new Game(2, "Cyberpunk 2077", "url_do_okladki", cdProjekt, 4.3f);

        Game gta = new Game(3, "GTA V", "url_do_okladki", rockstar, 4.8f);
        Game rdr2 = new Game(4, "Red Dead Redemption 2", "url_do_okladki", rockstar, 4.9f);

        Game skyrim = new Game(5, "Skyrim", "url_do_okladki", bethesda, 4.7f);
        Game fallout = new Game(6, "Fallout 4", "url_do_okladki", bethesda, 4.4f);

        Game darkSouls = new Game(7, "Dark Souls III", "url_do_okladki", fromSoftware, 4.6f);
        Game eldenRing = new Game(8, "Elden Ring", "url_do_okladki", fromSoftware, 4.9f);

        bind(witcher, cdProjekt);
        bind(cyberpunk, cdProjekt);
        bind(gta, rockstar);
        bind(rdr2, rockstar);
        bind(skyrim, bethesda);
        bind(fallout, bethesda);
        bind(darkSouls, fromSoftware);
        bind(eldenRing, fromSoftware);

        Platform pc = new Platform(1, "PC (Steam)", "url_logo");
        Platform ps5 = new Platform(2, "PlayStation 5", "url_logo");
        Platform xbox = new Platform(3, "Xbox Series X", "url_logo");

        bind(pc, witcher);
        bind(ps5, witcher);
        bind(xbox, witcher);
        bind(pc, cyberpunk);

        bind(ps5, gta);
        bind(xbox, gta);
        bind(pc, eldenRing);
        bind(ps5, eldenRing);

        games.add(witcher);
        games.add(cyberpunk);
        games.add(gta);
        games.add(rdr2);
        games.add(skyrim);
        games.add(fallout);
        games.add(darkSouls);
        games.add(eldenRing);

        studios.add(cdProjekt);
        studios.add(rockstar);
        studios.add(bethesda);
        studios.add(fromSoftware);

        platforms.add(pc);
        platforms.add(ps5);
        platforms.add(xbox);
    }

    private static void bind(Platform p, Game g) {
        p.addGame(g);
        g.addPlatforms(p);
    }

    private static void bind(Game g, Studio s) {
        s.addGame(g);
        g.setStudio(s);
    }
}