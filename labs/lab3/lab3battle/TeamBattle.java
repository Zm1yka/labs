package lab3battle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import lab3Droids.Droid;

public class TeamBattle implements battles {
    private List<Droid> team1;
    private List<Droid> team2;
    private StringBuilder battleLog = new StringBuilder(); 

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public void start() {
        System.out.println("Бій команда на команду!");

        int i = 0;
        while (i < team1.size() && i < team2.size()) {
            Droid droid1 = team1.get(i);
            Droid droid2 = team2.get(i);

            logAndPrint("Бій між " + droid1.getName() + " та " + droid2.getName());
            OnevsOneBattle battle = new OnevsOneBattle(droid1, droid2);
            battle.start();

            if (!droid1.isAlive()) {
                logAndPrint(droid2.getName() + " переміг!");
            } else if (!droid2.isAlive()) {
                logAndPrint(droid1.getName() + " переміг!");
            }

            i++;
        }

        if (isTeamAlive(team1) && !isTeamAlive(team2)) {
            logAndPrint("Команда 1 перемогла!");
        } else if (!isTeamAlive(team1) && isTeamAlive(team2)) {
            logAndPrint("Команда 2 перемогла!");
        } else {
            logAndPrint("Бій завершився внічию!");
        }

        saveBattleLogToFile();
    }

    private boolean isTeamAlive(List<Droid> team) {
        for (Droid droid : team) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private void logAndPrint(String message) {
        System.out.println(message);
        battleLog.append(message).append("\n");
    }
    
    public String getBattleLog() {
        return battleLog.toString();
    }

    private void saveBattleLogToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Maxx\\Desktop\\pp\\lab3.txt", true))) {
            writer.write(battleLog.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Помилка при записі файлу: " + e.getMessage());
        }
    }
}
