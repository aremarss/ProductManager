package ru.netology.domain;

import java.util.Objects;

public abstract class Product {
    private int id;
    private String name;
    private int cost;

    public Product() {
    }

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public boolean matches(String search) {
        Book book = new Book(search);
        if (book.getName().contains(search)) {
            return true;
        }
        Smartphone smartphone = new Smartphone(search);
        if (smartphone.getName().contains(search)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && cost == product.cost && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost);
    }
}