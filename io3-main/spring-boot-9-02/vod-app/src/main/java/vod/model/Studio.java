package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Studio {

    private int id;
    private String name;
    private String country;
    private List<Game> games = new ArrayList<>();//relacja 1 do wielu
//listy zeby przey przełączniu na SpringDate nie było komplikacji
//lista od seta różni się tym że są w niej powtórzenia oraz trzymamy kolejność wrzucania
    //struktury danych wazna rzecz w zachowaniu spójności danych w warstwie aplikacyjnej
    public Studio(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Studio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public void addGame(Game m) {
        this.games.add(m);
    }

    @Override
    public String toString() {
        return "Studio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
