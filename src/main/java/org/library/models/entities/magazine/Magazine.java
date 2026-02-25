package org.library.models.entities.magazine;



import org.library.models.entities.itemLibrary.ItemLibrary;
import org.library.models.entities.itemLibrary.utils.Status;
import org.library.models.entities.itemLibrary.utils.TypeItem;
import org.library.models.entities.magazine.utils.Frequency;

import java.time.LocalDate;

public class Magazine extends ItemLibrary {
    private Integer number;
    private Frequency frequency;
    private Integer volume;
    private String issn;

    public Magazine(Long id,
                    String title,
                    Integer quantity,
                    String description,
                    LocalDate datePublication,
                    Status status,
                    TypeItem typeItem,
                    Integer number,
                    Frequency frequency,
                    Integer volume,
                    String issn)
    {
        super(id, title, quantity, description, datePublication, status, typeItem);
        this.number = number;
        this.frequency = frequency;
        this.volume = volume;
        this.issn = issn;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    @Override
    public String toString() {
        return "Magazine{" + super.toString() +
                "number=" + number +
                ", frequency=" + frequency +
                ", volume=" + volume +
                ", issn='" + issn + '\'' +
                "} ";
    }
}
