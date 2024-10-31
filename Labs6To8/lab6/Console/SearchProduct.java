package Console;

import Truck.CoffeeTruck;
import coffee.CoffeeTypes;
import java.util.Scanner;

public class SearchProduct implements Command {
    private CoffeeTruck truck;

    public SearchProduct(CoffeeTruck coffeeTruck) {
        this.truck = (CoffeeTruck) coffeeTruck;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть мінімальну вагу:");
        double minWeight = scanner.nextDouble();

        System.out.println("Введіть максимальну вагу:");
        double maxWeight = scanner.nextDouble();

        System.out.println("Продукти в заданому діапазоні ваги:");
        for (CoffeeTypes coffee : truck.getProducts()) {
            if (coffee.getWeight() >= minWeight && coffee.getWeight() <= maxWeight) {
                System.out.println(coffee.getName() + " (" + coffee.getType() + ") - " + coffee.getWeight() + " г");
            }
        }
    }
}