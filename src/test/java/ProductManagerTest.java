import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    @Test
    public void testAdd() {
        Storage stor = new Storage();
        ProductManager repositories = new ProductManager(stor);

        Book book1 = new Book(1, "Fahrenheit 451", 500, "Ray Douglas Bradbury");
        Book book2 = new Book(2, "The Stainless Steel Rat", 375, "Harry Harrison");
        Book book3 = new Book(3,"Le Comte de Monte-Cristo", 900, "Alexandre Dumas");
        Book book4 = new Book(4,"Mort",20,"Sir Terence David John Pratchett");
        Book book5 = new Book(5, "Приключения Алисы", 150_000, "Кир Булычёв ");

        ProductManager.add(book1);
        ProductManager.add(book2);
        ProductManager.add(book3);
        ProductManager.add(book4);
        ProductManager.add(book5);

        Product[] expected = {book1, book2, book3, book4, book5};
        Product[] actual = stor.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }


}
