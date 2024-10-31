package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import coffee.BeanCoffee;
import coffee.GroundCoffe;
import coffee.InstantCoffee;

class CoffeeTypesTest {
    @Test
    void testBeanCoffeeCreationAndType() {
        BeanCoffee coffee = new BeanCoffee("Arabica", 100, 50, 0.5);
        assertEquals("Arabica", coffee.getName());
        assertEquals(100, coffee.getWeight());
        assertEquals(50, coffee.getPrice());
        assertEquals(0.5, coffee.getVolume());
        assertEquals("Зернова кава", coffee.getType());
    }

    @Test
    void testGroundCoffeeCreationAndType() {
        GroundCoffe coffee = new GroundCoffe("Robusta", 200, 80, 0.5);
        assertEquals("Robusta", coffee.getName());
        assertEquals(200, coffee.getWeight());
        assertEquals(80, coffee.getPrice());
        assertEquals(0.5, coffee.getVolume());
        assertEquals("Мелена кава", coffee.getType());
    }

    @Test
    void testInstantCoffeeCreationAndType() {
        InstantCoffee coffee = new InstantCoffee("Nescafe", 150, 90, 0.5);
        assertEquals("Nescafe", coffee.getName());
        assertEquals(150, coffee.getWeight());
        assertEquals(90, coffee.getPrice());
        assertEquals(0.5, coffee.getVolume());
        assertEquals("Розчинна кава", coffee.getType());
    }
}
