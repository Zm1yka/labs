package tests;

import coffee.BeanCoffee;
import coffee.GroundCoffe;
import coffee.InstantCoffee;
import Truck.CoffeeTruck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeTruckTest {
    private CoffeeTruck truck;

    @BeforeEach
    void setUp() {
        truck = new CoffeeTruck();
    }

    @Test
    void testAddProductWithinVolumeLimit() {
        BeanCoffee coffee = new BeanCoffee("Arabica", 500, 200, 0.5);
        assertTrue(truck.canLoad(coffee.getVolume()));
        truck.addProduct(coffee);
        assertEquals(1, truck.getProducts().size());
    }

    @Test
    void testAddProductExceedingVolumeLimit() {
        InstantCoffee coffee = new InstantCoffee("Instant", 1000, 500, 1500);
        assertFalse(truck.canLoad(coffee.getVolume()));
        truck.addProduct(coffee);
        assertEquals(0, truck.getProducts().size());
    }

    @Test
    void testSortByPriceToWeightRatio() {
        truck.addProduct(new BeanCoffee("Premium", 300, 100, 0.3)); 
        truck.addProduct(new GroundCoffe("Standard", 100, 50, 0.2)); 
        truck.sortByPriceToWeightRatio();
        assertEquals("Premium", truck.getProducts().get(0).getName());
    }

    @Test
    void testShowAllProductsEmpty() {
        assertEquals(0, truck.getProducts().size());
    }
}
