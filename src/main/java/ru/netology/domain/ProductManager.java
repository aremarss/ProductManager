package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class ProductManager {
    ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] delete(int id) {
        repository.removeById(id);
        return new Product[getAll().length];
    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public Product[] searchById(int id) {
        repository.findById(id);
        return new Product[id];
    }
}