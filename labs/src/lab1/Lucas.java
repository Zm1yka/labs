package lab1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 */
class LucasNumber {
    private int index;
    private int value;

    public LucasNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    public boolean isTriangular() {
        int n = 1;
        while (n * (n + 1) / 2 <= value) {
            if (n * (n + 1) / 2 == value) {
                return true;
            }
            n++;
        }
        return false;
    }
}
/**
 */
public class Lucas {

/**
 * 
 * @param M
 * @return
 */
    public static List<LucasNumber> generateLucasNumbers(int M) {
        List<LucasNumber> lucasNumbers = new ArrayList<>();
        int a = 2, b = 1;
        for (int i = 1; i <= M; i++) {
            if (i == 1) {
                lucasNumbers.add(new LucasNumber(i, a));
            } else if (i == 2) {
                lucasNumbers.add(new LucasNumber(i, b));
            } else {
                int next = a + b;
                lucasNumbers.add(new LucasNumber(i, next));
                a = b;
                b = next;
            }
        }
        return lucasNumbers;
    }
/**
 * 
 * @param args
 */
    public static void main(String[] args) {
    	try (Scanner scanner = new Scanner(System.in)){

	        System.out.print("Введіть кількість чисел Люка (M): ");
	        int M = scanner.nextInt();
	
	        List<LucasNumber> lucasNumbers = generateLucasNumbers(M);
	
	        System.out.println("Числа Люка і перевірка на трикутні числа:");
	        for (LucasNumber lucasNumber : lucasNumbers) {
	            System.out.printf("Число Люка #%d: %d", lucasNumber.getIndex(), lucasNumber.getValue());
	            if (lucasNumber.isTriangular()) {
	                System.out.println(" - Трикутне число");
	            } else {
	                System.out.println(" - Не трикутне число.");
	            }
	        }
	    }
    }
}
