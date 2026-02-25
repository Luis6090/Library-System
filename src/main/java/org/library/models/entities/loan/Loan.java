package org.library.models.entities.loan;

import java.time.LocalDate;

public class Loan {
    private Long idItem;
    private Long idReader;
    private LocalDate checkOutDate;
    private LocalDate dueDate;

    public Loan(Long idItem,
                Long idReader,
                LocalDate checkOutDate,
                LocalDate dueDate)
    {
        this.idItem = idItem;
        this.idReader = idReader;
        this.checkOutDate = checkOutDate;
        this.dueDate = dueDate;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdReader() {
        return idReader;
    }

    public void setIdReader(Long idReader) {
        this.idReader = idReader;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "idItem=" + idItem +
                ", idReader=" + idReader +
                ", checkOutDate=" + checkOutDate +
                ", dueDate=" + dueDate +
                '}';
    }
}