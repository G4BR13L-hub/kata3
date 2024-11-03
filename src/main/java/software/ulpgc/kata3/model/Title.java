package software.ulpgc.kata3.model;

import java.util.Objects;

public class Title {
    private final String title;
    private final int year;
    private final int duration;

    public Title(String title, int year, int duration) {
        this.title = title;
        this.year = year;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(year);
    }

    @Override
    public String toString() {
        return "Title{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }
}
