package mk.ukim.finki.napredno.exercises.ispitni.stopcorona;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class User {
    private String name;
    private String id;
    private List<ILocation> locations;
    private LocalDateTime timeInfected;
    private boolean isInfected;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        locations = new ArrayList<>();
    }


    public void setTimeInfected(LocalDateTime timeInfected) {
        this.timeInfected = timeInfected;
    }

    public void addLocation(List<ILocation> location) {
        locations.addAll(location);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public boolean isInfected() {
        return isInfected;
    }

    public void setInfected(boolean infected) {
        isInfected = infected;
    }

    public LocalDateTime getTimeInfected() {
        return timeInfected != null ? timeInfected : LocalDateTime.MAX;
    }

    public List<ILocation> getLocations() {
        return locations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public String userComplete() {
        return String.format("%s %s %s", getName(), getId(), timeInfected);
    }

    public String userHidden() {
        return String.format("%s %s****", name, id.substring(0, 4));
    }
}
