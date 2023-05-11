import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {

    protected Storage stor = new Storage();
    protected ProductManager repository = new ProductManager(stor);
    protected Product book1 = new Book(1, "Fahrenheit 451", 500, "Ray Douglas Bradbury");
    protected Product book2 = new Book(2, "The Stainless Steel Rat", 375, "Harry Harrison");
    protected Product book3 = new Book(56, "Le Comte de Monte-Cristo", 900, "Alexandre Dumas");
    protected Product book4 = new Book(11, "Mort", 20, "Sir Terence David John Pratchett");
    protected Product book5 = new Book(175, "Приключения Алисы", 150_000, "Кир Булычёв");
    protected Product book6 = new Book(178, "Приключения Алисы", 250_000, "Кир Булычёв");
    protected Product phone1 = new Smartphone(27, "Galaxy A03 Core", 6_999, "Samsung");
    protected Product phone2 = new Smartphone(9000, "A360", 2_999, "DEXP");
    protected Product phone3 = new Smartphone(101, "iPhone 14 Pro Max", 166_999, "Apple");
    protected Product phone4 = new Smartphone(8999, "Galaxy S23 Ultra", 139_999, "Samsung");
    protected Product phone5 = new Smartphone(555, "13 Pro", 99_999, "Xiaomi ");

    @BeforeEach
    public void setUp() {
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(book4);
        repository.add(book5);
        repository.add(book6);
        repository.add(phone1);
        repository.add(phone2);
        repository.add(phone3);
        repository.add(phone4);
        repository.add(phone5);
    }

    @Test
    public void shouldFindBookByName() {
        Product[] expected = new Product[]{book1};
        Product[] actual = repository.searchBy("Fahrenheit 451");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAuthor() {

    }

    @Test
    public void shouldFindTwoBookByName() {
        Product[] expected = new Product[]{book5, book6};
        Product[] actual = repository.searchBy("Приключения Алисы");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByName() {
        Product[] expected = new Product[]{phone3};
        Product[] actual = repository.searchBy("iPhone 14 Pro Max");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBook3ByName() {
        Product[] expected = new Product[]{book3};
        Product[] actual = repository.searchBy("Le Comte de Monte-Cristo");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNull() {
        Product[] expected = new Product[]{};
        Product[] actual = repository.searchBy("iPhone 13");
        assertArrayEquals(expected, actual);
    }
}
