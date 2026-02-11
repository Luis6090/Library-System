package models.entities.dvd;

import models.entities.itemLibrary.ItemLibrary;
import models.entities.itemLibrary.utils.Status;
import models.entities.itemLibrary.utils.TypeItem;

import java.time.LocalDate;
import java.time.LocalTime;

public class Dvd extends ItemLibrary {
    private LocalTime duration;
    private String director;
    private String productionHouse;


    public Dvd(Long id,
               String title,
               Integer quantity,
               String description,
               LocalDate datePublication,
               Status status,
               TypeItem typeItem,
               LocalTime duration,
               String director,
               String productionHouse)
    {
        super(id, title, quantity, description, datePublication, status, typeItem);
        this.duration = duration;
        this.director = director;
        this.productionHouse = productionHouse;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProductionHouse() {
        return productionHouse;
    }

    public void setProductionHouse(String productionHouse) {
        this.productionHouse = productionHouse;
    }

    @Override
    public String toString() {
        return "Dvd{" + super.toString() +
                "productionHouse='" + productionHouse + '\'' +
                ", director='" + director + '\'' +
                ", duration=" + duration +
                "} " ;
    }
}
