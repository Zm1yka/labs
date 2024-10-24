package Console;

import java.io.IOException;
import Truck.CoffeeTruck;
import coffee.CoffeeTypes;
import java.io.FileWriter;

public class SaveToFile implements Command {
    private CoffeeTruck coffeeTruck;

    public SaveToFile(CoffeeTruck coffeeTruck) {
        this.coffeeTruck = coffeeTruck;
    }

    @Override
    public void execute() {
        try (FileWriter writer = new FileWriter("C:\\\\Users\\\\Maxx\\\\Desktop\\\\pp\\\\lab6.txt")) {  
            for (CoffeeTypes product : coffeeTruck.getProducts()) {
                writer.write(product.toString() + "\n"); 
            }
            System.out.println("Продукти збережені у файл.");
        } catch (IOException e) {
            System.out.println("Помилка під час запису у файл.");
            e.printStackTrace();
        }
    }
}
