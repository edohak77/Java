package videoteka.lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film {
    private String name;
    private String contry;
    private Producer producer;
    private LocalDate reliseDate;
    private List<Actor> actorList = new ArrayList<>();

    public Film(String name, String contry, Producer producer, LocalDate reliseDate, List<Actor> actorList) {
        this.name = name;
        this.contry = contry;
        this.producer = producer;
        this.reliseDate = reliseDate;
        this.actorList = actorList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public LocalDate getReliseDate() {
        return reliseDate;
    }

    public void setReliseDate(LocalDate reliseDate) {
        this.reliseDate = reliseDate;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
