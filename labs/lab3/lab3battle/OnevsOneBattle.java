package lab3battle;

import lab3Droids.Droid;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OnevsOneBattle {
    private Droid droid1;
    private Droid droid2;
    private StringBuilder battleLog = new StringBuilder();

    public OnevsOneBattle(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    public void start() {
        while (droid1.isAlive() && droid2.isAlive()) {
            logAndPrint(droid1.getName() + " атакує " + droid2.getName() + " і наносить " + droid1.getDamage() + " урону.");
            droid2.takeDamage(droid1.getDamage());
            
            if (!droid2.isAlive()) {
                logAndPrint(droid2.getName() + " тепер має 0 здоров'я.");
                logAndPrint(droid1.getName() + " переміг!");
                saveBattleLogToFile();
                return;
            }
            logAndPrint(droid2.getName() + " тепер має " + droid2.getHealth() + " здоров'я.");
            
            logAndPrint(droid2.getName() + " атакує " + droid1.getName() + " і наносить " + droid2.getDamage() + " урону.");
            droid1.takeDamage(droid2.getDamage());
            
            if (!droid1.isAlive()) {
                logAndPrint(droid1.getName() + " тепер має 0 здоров'я.");
                logAndPrint(droid2.getName() + " переміг!");
                saveBattleLogToFile();
                return;  
            }
            logAndPrint(droid1.getName() + " тепер має " + droid1.getHealth() + " здоров'я.");
        }

        saveBattleLogToFile();
    }


    private void logAndPrint(String message) {
        System.out.println(message);
        battleLog.append(message).append("\n");
    }
    
    public String getBattleLog() {
        return battleLog.toString();
    }

    private void saveBattleLogToFile() {
        if (battleLog.length() > 0) { 
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Maxx\\Desktop\\pp\\lab3.txt", true))) {
                writer.write(battleLog.toString());
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Помилка при записі файлу: " + e.getMessage());
            }
        } else {
            System.err.println("Лог бою порожній. Немає чого записувати.");
        }
    }

}
