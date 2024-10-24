package lab3battle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import lab3Droids.Droid;
import lab3Droids.SupportDroid;

public class TeamBattle implements battles {
    private List<Droid> team1;
    private List<Droid> team2;
    private StringBuilder battleLog = new StringBuilder(); 
    private Scanner scanner = new Scanner(System.in);

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public void start() {
        System.out.println("Бій команда на команду!");

        while (isTeamAlive(team1) && isTeamAlive(team2)) {
        	for(int i = 0 ; i < Math.min(team1.size(), team2.size()) ; i++) {
        	
            Droid droid1 = team1.get(i);
            Droid droid2 = team2.get(i);
            
            if(droid1.isAlive() && droid2.isAlive()) {
            logAndPrint("Бій між " + droid1.getName() + " та " + droid2.getName());
           
            if(droid1 instanceof SupportDroid) {
            	SupportDroidchoice((SupportDroid) droid1, team1 , droid2);
            }else {
            	droid1.attack(droid2);
            }
            
            if(!droid2.isAlive()) {
            	logAndPrint(droid2.getName() + " загинув ");
            }
            
            if(droid2.isAlive()) {
            	if(droid2 instanceof SupportDroid) {
            		SupportDroidchoice((SupportDroid) droid2 , team2, droid1);
            	}else {
            		droid2.attack(droid1);
            	}
            	
            	if(!droid1.isAlive()) {
            		logAndPrint(droid1.getName() + " загинув");
            	}
            }
        }
     }
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
    
    
    private void SupportDroidchoice(SupportDroid supportDroid, List<Droid> team , Droid enemy) {
    	System.out.println(supportDroid.getName()+ " оберіть дію для дроїда: ");
    	System.out.println("1. Аттакувати ворога");
    	System.out.println("2. Лікувати союзника");
    
	int choice = scanner.nextInt();
    
    if (choice == 1 ) {
    	supportDroid.attack(enemy);
    }else if (choice == 2 ) {
    	System.out.println("Оберіть союзника для лікування ");
    	for ( int j = 0 ; j < team.size(); j++) {
    		if (team.get(j).isAlive()) {
    			System.out.println((j + 1) + ". " + team.get(j).getName());
    		}
    	}
    	
    	int allyIndex = scanner.nextInt() - 1;
    	Droid ally = team.get(allyIndex);
    	supportDroid.heal(ally);
    }
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
