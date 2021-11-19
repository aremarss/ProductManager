package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {
    private String author;

    public Book() {
    }

    public Book(String author) {
        this.author = author;
    }

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean matches(Product product, String search) {
        if (super.matches(product, search)) {
            return true;
        }
        if (getAuthor().contains(search)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }
}