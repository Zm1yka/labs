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
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Maxx\\Desktop\\pp\\lab6.txt"))) {
            String line;
            coffeeTruck.clearProducts();
            while ((line = reader.readLine()) != null) {
                CoffeeTypes product = parseProduct(line);
                coffeeTruck.addProduct(product);
            }
            System.out.println("Продукти завантажені з файлу.");
        } catch (IOException e) {
            System.out.println("Помилка під час зчитування файлу.");
            e.printStackTrace();
        }
    }

    private CoffeeTypes parseProduct(String line) {
        String[] parts = line.split(", ");
        String coffeeType = parts[0].split(":")[0].trim();

        double weight = Double.parseDouble(parts[1].split(": ")[1].replaceAll("[^\\d,]", "").replace(",", "."));
        double price = Double.parseDouble(parts[2].split(": ")[1].replaceAll("[^\\d,]", "").replace(",", "."));
        double volume = Double.parseDouble(parts[3].split(": ")[1].replaceAll("[^\\d,]", "").replace(",", "."));

        switch (coffeeType) {
            case "Зернова кава":
                return new BeanCoffee("Зернова кава", weight, price, volume);
            case "Мелена кава":
                return new GroundCoffe("Мелена кава", weight, price, volume);
            case "Розчинна кава":
                return new InstantCoffee("Розчинна кава", weight, price, volume);
            default:
                throw new IllegalArgumentException("Невідомий тип кави: " + coffeeType);
        }
    }
}