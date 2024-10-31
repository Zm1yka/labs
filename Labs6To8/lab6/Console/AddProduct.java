package Console;

import coffee.BeanCoffee;
import coffee.CoffeeTypes;
import coffee.GroundCoffe;
import coffee.InstantCoffee;
import Truck.CoffeeTruck;
import java.util.Scanner;

public class AddProduct implements Command {
    private CoffeeTruck truck;

    public AddProduct(CoffeeTruck coffeeTruck) {
        this.truck = coffeeTruck;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Оберіть тип кави: 1 - Зернова, 2 - Мелена, 3 - Розчинна");
        int type = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Введіть назву продукту:");
        String name = scanner.nextLine();

        System.out.println("Введіть вагу продукту (в грамах):");
        double weight = scanner.nextDouble();

        System.out.println("Введіть ціну продукту:");
        double price = scanner.nextDouble();

        System.out.println("Введіть об'єм продукту (в літрах):");
        double volume = scanner.nextDouble(); // Get the volume

        CoffeeTypes coffee;
        switch (type) {
            case 1:
                coffee = new BeanCoffee(name, weight, price, volume);
                break;
            case 2:
                coffee = new GroundCoffe(name, weight, price, volume);
                break;
            case 3:
                coffee = new InstantCoffee(name, weight, price, volume);
                break;
            default:
                System.out.println("Невірний тип кави.");
                return;
        }

        if (truck.canLoad(volume)) {
            truck.addProduct(coffee);
            System.out.println("Продукт додано до фургона.");
        } else {
            System.out.println("Неможливо додати продукт. Перевищено ліміт об'єму.");
        }
    }
}
