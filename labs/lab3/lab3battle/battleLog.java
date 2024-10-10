package lab3battle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class battleLog {
    private static String FILE_NAME = "C:\\Users\\Maxx\\Desktop\\pp\\lab3.txt";

    public static void logBattle(String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(log + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void replayBattle() {
        try {
            Files.lines(Paths.get(FILE_NAME)).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
