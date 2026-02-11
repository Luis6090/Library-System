package models.entities.itemLibrary;

import models.entities.itemLibrary.utils.Status;
import models.entities.itemLibrary.utils.TypeItem;

import java.time.LocalDate;

public abstract class ItemLibrary {
    private Long id;
    private String title;
    private Integer quantity;
    private String description;
    private LocalDate datePublication;
    private Status status;
    private TypeItem typeItem;

    public ItemLibrary(Long id,
                       String title,
                       Integer quantity,
                       String description,
                       LocalDate datePublication,
                       Status status,
                       TypeItem typeItem)
    {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.description = description;
        this.datePublication = datePublication;
        this.status = status;
        this.typeItem = typeItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TypeItem getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(TypeItem typeItem) {
        this.typeItem = typeItem;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                ", status=" + status +
                ", typeItem=" + typeItem;
    }
}
