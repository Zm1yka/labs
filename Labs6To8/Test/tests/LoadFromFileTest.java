package tests;

import Truck.CoffeeTruck;
import coffee.CoffeeTypes;
import coffee.BeanCoffee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Console.LoadFromFile;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadFromFileTest {
    private CoffeeTruck coffeeTruck;
    private LoadFromFile loadFromFile;
    private String filePath;

    @BeforeEach
    public void setUp() throws IOException {
        coffeeTruck = new CoffeeTruck();

        filePath = "C:\\Users\\Maxx\\Desktop\\pp\\lab6.txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Зернова кава: Назва: Arabica, Вага: 250.0 г, Ціна: 120.0 грн, Об'єм: 0.5 л\n");
        }

        loadFromFile = new LoadFromFile(coffeeTruck);
    }

    @Test
    public void testExecute() {
        loadFromFile.execute();
        assertEquals(1, coffeeTruck.getProducts().size());

        CoffeeTypes product = coffeeTruck.getProducts().get(0);
        System.out.println("Вага: " + product.getWeight());
        assertTrue(product instanceof BeanCoffee);
        assertEquals("Зернова кава", product.getName());
        assertEquals(250.0, product.getWeight());
        assertEquals(120.0, product.getPrice());
        assertEquals(0.5, product.getVolume());
    }
}
