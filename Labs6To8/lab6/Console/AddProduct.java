package Console;

import coffee.BeanCoffee;
import coffee.CoffeeTypes;
import coffee.GroundCoffe;
import coffee.InstantCoffee;
import Truck.CoffeeTruck;
import logging.LogManager;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddProduct implements Command {
    private static final Logger logger = LogManager.getLogger();
    private CoffeeTruck truck;

    public AddProduct(CoffeeTruck coffeeTruck) {
        this.truck = coffeeTruck;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Оберіть тип кави: 1 - Зернова, 2 - Мелена, 3 - Розчинна");
            int type = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Введіть назву продукту:");
            String name = scanner.nextLine();

            System.out.println("Введіть вагу продукту (в грамах):");
            double weight = scanner.nextDouble();

            System.out.println("Введіть ціну продукту:");
            double price = scanner.nextDouble();

            System.out.println("Введіть об'єм продукту (в літрах):");
            double volume = scanner.nextDouble();

            CoffeeTypes coffee;
            switch (type) {
                case 1 -> coffee = new BeanCoffee(name, weight, price, volume);
                case 2 -> coffee = new GroundCoffe(name, weight, price, volume);
                case 3 -> coffee = new InstantCoffee(name, weight, price, volume);
                default -> {
                    logger.log(Level.WARNING, "Невірний тип кави");
                    System.out.println("Невірний тип кави.");
                    return;
                }
            }

            if (truck.canLoad(volume)) {
                truck.addProduct(coffee);
                logger.log(Level.INFO, "Продукт додано до фургона: " + coffee.getName());
                System.out.println("Продукт додано до фургона.");
            } else {
                logger.log(Level.WARNING, "Перевищено ліміт об'єму для продукту: " + coffee.getName());
                System.out.println("Неможливо додати продукт. Перевищено ліміт об'єму.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Помилка під час додавання продукту", e);
            System.out.println("Помилка під час додавання продукту.");
        }
    }
}
