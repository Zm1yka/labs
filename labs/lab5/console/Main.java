package console;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();

        menu.addCommand(1, new AddProduct());
        menu.addCommand(2, new SortProduct());
        menu.addCommand(3, new SearchProduct());
        menu.addCommand(4, new SaveToFile());
        menu.addCommand(5, new LoadFromFile());
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
