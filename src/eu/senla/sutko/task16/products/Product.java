package eu.senla.sutko.task16.products;

import java.time.LocalDate;

public class Product {
    public Product(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    private int id;
    private String name;
    private LocalDate date;

    @Override
    public String toString() {
        return "Товар " +
                "ID-" + id +
                " name " + name +
                " date " + date ;
    }
}
