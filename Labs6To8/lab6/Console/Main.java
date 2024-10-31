package Console;

import java.util.Scanner;
import Truck.CoffeeTruck;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeTruck coffeeTruck = new CoffeeTruck(); 

        Menu menu = new Menu();

        menu.addCommand(1, new AddProduct(coffeeTruck));  
        menu.addCommand(2, new SearchProduct(coffeeTruck)); 
        menu.addCommand(3, new SortProductByPriceToWeight(coffeeTruck)); 
        menu.addCommand(4, new SaveToFile(coffeeTruck)); 
        menu.addCommand(5, new LoadFromFile(coffeeTruck));
        menu.addCommand(0, new Exit()); 

        boolean running = true;
        while (running) {
            menu.showMenu();
            System.out.println("Оберіть пункт меню:");
            int option = scanner.nextInt();
            menu.executeCommand(option);
        }

        scanner.close();
    }
}
