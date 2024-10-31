package sdasd;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<Integer, Command> commandMap;

    public Menu() {
        commandMap = new HashMap<>();
    }

    public void addCommand(int option, Command command) {
        commandMap.put(option, command);
    }

    public void showMenu() {
        System.out.println("\n--- Меню ---");
        System.out.println("1. Додати новий продукт");
        System.out.println("2. Сортувати продукти за співвідношенням ціни до ваги");
        System.out.println("3. Пошук продукту за параметрами якості");
        System.out.println("4. Зберегти продукти у файл");
        System.out.println("5. Завантажити продукти з файлу");
        System.out.println("0. Вихід");
    }

    public void executeCommand(int option) {
        Command command = commandMap.get(option);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Невірний вибір, спробуйте ще раз.");
        }
    }
}
