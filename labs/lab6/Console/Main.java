package Console;

import java.util.Scanner;
import Truck.CoffeeTruck;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeTruck coffeeTruck = new CoffeeTruck();  // Створюємо об'єкт фургону з кавою

        Menu menu = new Menu();

        menu.addCommand(1, new AddProduct(coffeeTruck));  // Додати продукт
        menu.addCommand(2, new SearchProduct(coffeeTruck)); // Пошук продукту
        menu.addCommand(3, new SortProductByPriceToWeight(coffeeTruck)); // Додано для сортування
        menu.addCommand(4, new SaveToFile(coffeeTruck)); // Зберегти у файл
        menu.addCommand(5, new LoadFromFile(coffeeTruck)); // Завантажити з файлу
        menu.addCommand(0, new Exit()); // Вихід

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
