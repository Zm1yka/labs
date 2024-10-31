package tests;

import Console.AddProduct;
import Truck.CoffeeTruck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.*;

class AddProductTest {
    private CoffeeTruck truck;
    private AddProduct addProductCommand;

    @BeforeEach
    void setUp() {
        truck = new CoffeeTruck();
        addProductCommand = new AddProduct(truck);
    }

    @Test
    void testExecute() {
        String input = "1\nArabica\n500\n200\n0,5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        addProductCommand.execute();

        assertEquals(1, truck.getProducts().size());
        assertEquals("Arabica", truck.getProducts().get(0).getName());
    }
}
