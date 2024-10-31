package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Truck.CoffeeTruck;
import Console.SortProductByPriceToWeight;
import coffee.BeanCoffee;
import coffee.GroundCoffe;
import coffee.InstantCoffee;

class SortProductByPriceToWeightTest {
    private CoffeeTruck coffeeTruck;
    private SortProductByPriceToWeight sortCommand;

    @BeforeEach
    void setUp() {
        coffeeTruck = new CoffeeTruck();
        sortCommand = new SortProductByPriceToWeight(coffeeTruck);

        // Додаємо продукти для тестування сортування
        coffeeTruck.addProduct(new BeanCoffee("Arabica", 100, 50, 0.5));
        coffeeTruck.addProduct(new GroundCoffe("Robusta", 200, 80, 0.5));
        coffeeTruck.addProduct(new InstantCoffee("Nescafe", 150, 90, 0.5));
    }

    @Test
    void testExecuteSortByPriceToWeight() {
        sortCommand.execute();
        
        // Перевірка порядку сортування після виконання команди
        assertEquals("Arabica", coffeeTruck.getProducts().get(0).getName());  // Найменше співвідношення ціни до ваги
        assertEquals("Robusta", coffeeTruck.getProducts().get(1).getName());  // Середнє співвідношення
        assertEquals("Nescafe", coffeeTruck.getProducts().get(2).getName());  // Найбільше співвідношення
    }
}
