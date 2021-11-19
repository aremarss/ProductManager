package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String maker;

    public Smartphone() {
    }

    public Smartphone(String maker) {
        this.maker = maker;
    }

    public Smartphone(int id, String name, int cost, String maker) {
        super(id, name, cost);
        this.maker = maker;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public boolean matches(Product product, String search) {
        if (super.matches(product, search)) {
            return true;
        }
        if (getMaker().contains(search)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return maker.equals(that.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maker);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "maker='" + maker + '\'' +
                '}';
    }
}