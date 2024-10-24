package sdasd;

public class Exit implements Command {
    @Override
    public void execute() {
        System.out.println("Вихід з програми...");
        System.exit(0); 
    }
}
