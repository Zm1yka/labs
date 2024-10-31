package tests;

import Console.SearchProduct;
import coffee.BeanCoffee;
import Truck.CoffeeTruck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchProductTest {
    private CoffeeTruck truck;
    private SearchProduct searchProductCommand;

    @BeforeEach
    void setUp() {
        truck = new CoffeeTruck();
        searchProductCommand = new SearchProduct(truck);
    }

    @Test
    void testExecute() {
        truck.addProduct(new BeanCoffee("Arabica", 500, 200, 0.5));
        String input = "200\n600\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        searchProductCommand.execute();
        assertEquals(1, truck.getProducts().size());
    }
}
