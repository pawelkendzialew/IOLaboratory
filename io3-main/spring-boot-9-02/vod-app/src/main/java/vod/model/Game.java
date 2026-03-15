package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int id;
    private String title;
    private String cover;//url
    private Studio studio;//relacja do rezysera - kolejny obiekt danych w uproszczeniu założenie że jeden film ma 1 reżysera
    private float rating;//rating
    private List<Platform> platforms = new ArrayList<>();
//relacja wiele do wiele - bidirectional

    public Game(int id, String title, String cover, Studio studio, float rating) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.studio = studio;
        this.rating = rating;
    }

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatform(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public void addPlatform(Platform c) {
        this.platforms.add(c);
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        return poster != null ? poster.equals(movie.poster) : movie.poster == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }*/

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", studio=" + studio +
                ", rating=" + rating +
                '}';
    }
}
