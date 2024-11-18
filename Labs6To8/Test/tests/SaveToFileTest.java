package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Console.SaveToFile;
import coffee.BeanCoffee;
import Truck.CoffeeTruck;
import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class SaveToFileTest {
    private CoffeeTruck truck;
    private SaveToFile saveToFileCommand;
    private final String testFilePath = "C:\\Users\\Maxx\\Desktop\\pp\\lab6.txt";

    @BeforeEach
    void setUp() {
        truck = new CoffeeTruck();
        saveToFileCommand = new SaveToFile(truck);
        truck.addProduct(new BeanCoffee("TestCoffee", 500, 200, 0.5));
    }

    @Test
    void testExecute() {
        saveToFileCommand.execute();
        File file = new File(testFilePath);
        assertTrue(file.exists());

        try {
            String content = Files.readString(file.toPath());
            assertTrue(content.contains("TestCoffee"));
        } catch (IOException e) {
            fail("Не вдається прочитати файл.");
        }
    }
}
