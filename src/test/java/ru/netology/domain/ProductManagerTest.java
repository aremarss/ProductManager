package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Book 1", 500, "Pelevin");
    private Book secondBook = new Book(2, "Book 2", 460, "Lermontov");
    private Book thirdBook = new Book(3, "Book 3", 720, "Bronte");
    private Smartphone firstSmart = new Smartphone(4, "Galaxy", 19999, "Samsung");
    private Smartphone secondSmart = new Smartphone(5, "Galaxy", 19999, "Xiaomi");
    private Smartphone thirdSmart = new Smartphone(6, "iPhone 12", 59999, "Apple");
    private Smartphone fourthSmart = new Smartphone(7, "iPhone 13", 69999, "Apple");

    @BeforeEach
    void add() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstSmart);
        manager.add(secondSmart);
        manager.add(thirdSmart);
        manager.add(fourthSmart);
    }

    @Test
    void shouldFindAll() {
        Product[] expected = new Product[]{firstBook, secondBook, thirdBook, firstSmart, secondSmart, thirdSmart, fourthSmart};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByAuthorBook() {
        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Pelevin");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByNameBook() {
        Product[] expected = new Product[]{secondBook};
        Product[] actual = manager.searchBy("Book 2");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByNameSmartphone() {
        Product[] expected = new Product[]{secondSmart};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSeveralFindByNameSmartphone() {
        Product[] expected = new Product[]{firstSmart, secondSmart};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSeveralFindSmartByMaker() {
        Product[] expected = new Product[]{thirdSmart, fourthSmart};
        Product[] actual = manager.searchBy("Apple");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFound() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Someone");
        assertArrayEquals(expected, actual);
    }
}
