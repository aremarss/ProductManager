## Задача №2 - "Менеджер Товаров" (Rich Model)*

**Важно**: это необязательная задача. Её (не)выполнение не влияет на получение зачёта по ДЗ.

### Легенда

Достаточно часто объекты, моделирующие предметную область, называют моделями. Достаточно часто модели делают "глупыми", т.е. не содержащими никакой логики.

Но есть и другой подход, который позволяет делать "умные" или "богатые" модели (Rich Model), которые могут уже содержать определённую логику.

Что нужно сделать:
1. Создайте новую ветку на базе ветки, в которой вы решали первую задачу
1. Реализуйте в классе `Product` метод `public boolean matches(String search)`, который определяет, подходит ли продукт поисковому запросу исходя из названия
1. Переопределите этот метод в дочерних классах, чтобы они сначала вызывали родительский метод и только если родительский метод вернул `false`, тогда проводили доп.проверки (`Book` - по автору, `Smartphone` - по производителю).
1. Уберите из менеджера все `instanceof` и метод `matches`, т.к. теперь у вас "умные" модели и благодаря переопределению методов вам этот код больше не нужен
1. Зато теперь вам нужны unit-тесты на методы ваших умных моделей (напишите их)
1. Удостоверьтесь, что ранее написанные тесты на менеджера (из решения задачи 1) проходят

Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код в двух ветках (в `master` должен быть только `pom.xml`).

<details>
  <summary>Подсказка №1</summary>

```java
public class ProductManager {
  // добавьте необходимые поля, конструкторы и методы

  public Product[] searcyBy(String text) {
    Product[] result = new Product[0];
    for (Product product: repository.findAll()) {
      if (product.matches(text)) {
        Product[] tmp = new Product[result.length + 1];
        // используйте System.arraycopy, чтобы скопировать всё из result в tmp
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }
}
```
</details>

<details>
  <summary>Подсказка №2 (про оператор ||)</summary>

У нас есть замечательный логический оператор `||`, который работает следующим образом: вычисляет правую часть выражения только в случае, если левая равна `false`

```java
public class Book {
  // ваши поля, конструкторы, методы
  public boolean matches(String search) {
    return super.matches(search) || ... ваше выражение ...;
  }
}
```

Никто не говорит, что этот вариант лучше вот этого (наоборт, этот легче тестировать и отлаживать):
```java
public class Book {
  // ваши поля, конструкторы, методы
  public boolean matches(String search) {
    if (super.matches(search)) {
      return true;
    }
    return ... ваше выражение ...;
  }
}
```

Но вы должны знать оба варианта.
</details>