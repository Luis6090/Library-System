package models.entities.cd;

import models.entities.itemLibrary.ItemLibrary;
import models.entities.itemLibrary.utils.Status;
import models.entities.itemLibrary.utils.TypeItem;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cd extends ItemLibrary {
    private LocalTime duration;
    private String productionHouse;

    public Cd(Long id,
              String title,
              Integer quantity,
              String description,
              LocalDate datePublication,
              Status status,
              TypeItem typeItem,
              LocalTime duration,
              String productionHouse)
    {
        super(id, title, quantity, description, datePublication, status, typeItem);
        this.duration = duration;
        this.productionHouse = productionHouse;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getProductionHouse() {
        return productionHouse;
    }

    public void setProductionHouse(String productionHouse) {
        this.productionHouse = productionHouse;
    }

    @Override
    public String toString() {
        return "Cd{" + super.toString() +
                "duration=" + duration +
                ", productionHouse='" + productionHouse + '\'' +
                "} " ;
    }
}
