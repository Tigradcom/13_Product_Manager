import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StorageTest {
    protected Storage stor = new Storage();
    protected Product book1 = new Book(1, "Fahrenheit 451", 500, "Ray Douglas Bradbury");
    protected Product book2 = new Book(2, "The Stainless Steel Rat", 375, "Harry Harrison");
    protected Product book3 = new Book(56,"Le Comte de Monte-Cristo", 900, "Alexandre Dumas");
    protected Product book4 = new Book(11,"Mort",20,"Sir Terence David John Pratchett");
    protected Product book5 = new Book(175, "Приключения Алисы", 150_000, "Кир Булычёв ");
    protected Product phone1 = new Smartphone(27, "Galaxy A03 Core",6_999, "Samsung");
    protected Product phone2 = new Smartphone(9_000, "A360",2_999, "DEXP");
    protected Product phone3 = new Smartphone(0, "iPhone 14 Pro Max",166_999, "Apple");
    protected Product phone4 = new Smartphone(8_999, "Galaxy S23 Ultra",139_999, "Samsung");
    protected Product phone5 = new Smartphone(555, "13 Pro",99_999, "Xiaomi ");

    @Test
    void shouldNotSaveAnything() {
        Product[] expected = new Product[]{};
        Product[] actual = stor.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAllProducts() {
        stor.add(book2);
        stor.add(book3);
        stor.add(book1);
        stor.add(book5);
        stor.add(book4);
        stor.add(phone5);
        stor.add(phone3);
        stor.add(phone4);
        stor.add(phone2);
        stor.add(phone1);

        Product[] expected = new Product[]{book2, book3,book1,book5,book4,phone5,phone3,phone4,phone2,phone1};
        Product[] actual = stor.findAll();
        assertArrayEquals(expected, actual);
    }
    @Test
    void TestAddBook() {
        stor.add(book1);
        stor.add(book2);
        stor.add(book3);
        stor.add(book4);
        stor.add(book5);
        Product[] expected = {book1,book2,book3,book4,book5};
        Product[] actual = stor.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void TestAddSmartphone() {
        stor.add(phone1);
        stor.add(phone2);
        stor.add(phone3);
        stor.add(phone4);
        stor.add(phone5);
        Product[] expected = {phone1,phone2,phone3,phone4,phone5};
        Product[] actual = stor.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void TestAddAll(){
        stor.add(book2);
        stor.add(book3);
        stor.add(book1);
        stor.add(book5);
        stor.add(book4);
        stor.add(phone5);
        stor.add(phone3);
        stor.add(phone4);
        stor.add(phone2);
        stor.add(phone1);

        Product[] expected = {book2,book3,book1,book5,book4,phone5,phone3,phone4,phone2,phone1};
        Product[] actual = stor.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldDeletedByIDTwoProduct() {
        stor.add(book2);
        stor.add(book3);
        stor.add(book1);
        stor.add(phone5);
        stor.add(phone3);

        Product[] expected = new Product[]{book3,book1,phone3};
        stor.removeId(2);
        stor.removeId(555);
        Product[] actual = stor.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldStayEmpty() {
        stor.add(book2);
        stor.add(book3);
        stor.add(book1);
        stor.add(book5);
        stor.add(book4);
        stor.add(phone5);
        stor.add(phone3);
        stor.add(phone4);
        stor.add(phone2);
        stor.add(phone1);

        Product[] expected = new Product[]{};
        stor.removeId(1);
        stor.removeId(2);
        stor.removeId(56);
        stor.removeId(11);
        stor.removeId(175);
        stor.removeId(27);
        stor.removeId(9_000);
        stor.removeId(0);
        stor.removeId(8_999);
        stor.removeId(555);

        Product[] actual = stor.findAll();
        assertArrayEquals(expected, actual);
    }

}
