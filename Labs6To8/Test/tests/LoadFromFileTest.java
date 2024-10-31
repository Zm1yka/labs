package tests;

import Console.LoadFromFile;
import Truck.CoffeeTruck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LoadFromFileTest {
    private CoffeeTruck truck;
    private LoadFromFile loadFromFileCommand;

    @BeforeEach
    void setUp() {
        truck = new CoffeeTruck();
        loadFromFileCommand = new LoadFromFile(truck);
    }

    @Test
    void testExecute() {
        loadFromFileCommand.execute();
        assertEquals(1, truck.getProducts().size());
        assertEquals("TestCoffee", truck.getProducts().get(0).getName());
    }
}
