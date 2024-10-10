package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lab3Droids.BattleDroid;
import lab3Droids.Droid;
import lab3Droids.SupportDroid;
import lab3battle.OnevsOneBattle;
import lab3battle.TeamBattle;
import lab3battle.battleLog;

public class Console {
    private List<Droid> droids = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Команда на команду");
            System.out.println("5. Записати бій у файл");
            System.out.println("6. Відтворити бій з файлу");
            System.out.println("7. Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createDroid();
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    startOneOnOneBattle();
                    break;
                case 4:
                    startTeamBattle();
                    break;
                case 5:
				Droid droid1 = null;
				Droid droid2 = null;
				OnevsOneBattle oneOnOneBattle = new OnevsOneBattle(droid1, droid2);
                    battleLog.logBattle(oneOnOneBattle.getBattleLog()); 
                    
				List<Droid> team2 = null;
				List<Droid> team1 = null;
				TeamBattle teamBattle = new TeamBattle(team1, team2);
                    battleLog.logBattle(teamBattle.getBattleLog()); 
                    break;

                case 6:
                    battleLog.replayBattle();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private void createDroid() {
        System.out.println("1. Battle Droid");
        System.out.println("2. Support Droid");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();

        if (choice == 1) {
            droids.add(new BattleDroid(name));
        } else if (choice == 2) {
            droids.add(new SupportDroid(name));
        }
        System.out.println("Дроїд створений!");
    }

    private void showDroids() {
        System.out.println("Список дроїдів:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.println((i + 1) + ". " + droids.get(i).getName());
        }
    }

    private void startOneOnOneBattle() {
        System.out.println("Виберіть двох дроїдів для бою 1 на 1:");
        showDroids();
        int droid1Index = scanner.nextInt() - 1;
        int droid2Index = scanner.nextInt() - 1;

        Droid droid1 = droids.get(droid1Index);
        Droid droid2 = droids.get(droid2Index);

        new OnevsOneBattle(droid1, droid2).start();
    }

    private void startTeamBattle() {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів для командного бою.");
            return;
        }

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        System.out.println("Оберіть дроїдів для команди 1:");
        showDroids();
        for (int i = 0; i < droids.size() / 2; i++) {
            team1.add(droids.get(scanner.nextInt() - 1));
        }

        System.out.println("Оберіть дроїдів для команди 2:");
        for (int i = 0; i < droids.size() / 2; i++) {
            team2.add(droids.get(scanner.nextInt() - 1));
        }

        TeamBattle battle = new TeamBattle(team1, team2);
        battle.start();
    }

}
