package Console;

import Truck.CoffeeTruck;
import coffee.BeanCoffee;
import coffee.GroundCoffe;
import coffee.InstantCoffee;
import coffee.CoffeeTypes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadFromFile implements Command {
    private CoffeeTruck coffeeTruck;

    public LoadFromFile(CoffeeTruck coffeeTruck) {
        this.coffeeTruck = coffeeTruck;
    }

    @Override
    public void execute() {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            coffeeTruck.clearProducts(); // Очищаємо старі продукти перед завантаженням
            while ((line = reader.readLine()) != null) {
                CoffeeTypes product = parseProduct(line);
                coffeeTruck.addProduct(product); // Додаємо новий продукт у фургон
            }
            System.out.println("Продукти завантажені з файлу.");
        } catch (IOException e) {
            System.out.println("Помилка під час зчитування файлу.");
            e.printStackTrace();
        }
    }

    // Метод для парсингу рядка з файлу у продукт
    private CoffeeTypes parseProduct(String line) {
        // Розбиваємо рядок на частини: "тип кави, вага, ціна, об'єм"
        String[] parts = line.split(", ");
        String coffeeType = parts[0];           // Тип кави
        double weight = Double.parseDouble(parts[1]);  // Вага продукту
        double price = Double.parseDouble(parts[2]);   // Ціна продукту
        double volume = Double.parseDouble(parts[3]);  // Об'єм продукту

        // Визначаємо тип кави та створюємо відповідний об'єкт
        switch (coffeeType) {
            case "BeanCoffee":
                return new BeanCoffee(coffeeType, weight, price, volume);
            case "GroundCoffee":
                return new GroundCoffe(coffeeType, weight, price, volume);
            case "InstantCoffee":
                return new InstantCoffee(coffeeType, weight, price, volume);
            default:
                throw new IllegalArgumentException("Невідомий тип кави: " + coffeeType);
        }
    }
}
