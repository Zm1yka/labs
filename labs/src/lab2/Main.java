package lab2;

import lab2.Phone;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    		try (Scanner scanner = new Scanner(System.in)){
    		Phone[] phones = createPhone(scanner)	;
    		
    		if (phones != null) {
    			System.out.println("Абоненти з часом міських розмов більше заданого:");
    			printLocalCallsExceeding(phones, 100);
        
        		System.out.println("\nАбоненти, які користувались міжміським зв'язком:");
        		printLongDistanceUsers(phones);
        
        		System.out.println("\nАбоненти з балансом рахунку в діапазоні:");
        		printAccountInRange(phones, "100", "300");
    		} else {
                System.out.println("Масив абонентів порожній або не створений.");
            }
    	}
    }

    public static Phone[] createPhone(Scanner scanner) {
    	System.out.print("Скільки номерів ви хочете ввести?  -  ");
    	int numberOfPhone = scanner.nextInt();
    	scanner.nextLine();
    	
    	if (numberOfPhone <= 0) {
            System.out.println("Невірна кількість абонентів.");
            return null;
        }
    	
    	Phone[] phones = new Phone[numberOfPhone];
    	
    	for(int i = 0; i < numberOfPhone ; i++) {
    		System.out.println("\nВведіть дані для абонента " + (i + 1));
    		
    		System.out.print("id: ");
            int id = scanner.nextInt();
            scanner.nextLine();  
            
            System.out.print("Прізвище: ");
            String lastName = scanner.nextLine();
            
            System.out.print("Ім'я: ");
            String Name = scanner.nextLine();
            
            System.out.print("По батькові: ");
            String middleName = scanner.nextLine();
            
            System.out.print("Баланс рахунку: ");
            String accountNumber = scanner.nextLine();
            
            System.out.print("Час міських розмов: ");
            int localTime = scanner.nextInt();
            scanner.nextLine();  
            
            System.out.print("Час міжміських розмов: ");
            int DistansTime = scanner.nextInt();
            scanner.nextLine();  
            
            phones[i] = new Phone(id, lastName, Name, middleName, accountNumber, localTime, DistansTime);
    	}
    	
    	return phones;
    }
    
    public static void printLocalCallsExceeding(Phone[] phones, int limit) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getLocalCallDuration() > limit) {
                System.out.println(phones[i]);
            }
        }
    }
    
    public static void printLongDistanceUsers(Phone[] phones) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getLongDistanceCallDuration() > 0) {
                System.out.println(phones[i]);
            }
        }
    }

    public static void printAccountInRange(Phone[] phones, String first, String last) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].getAccountNumber().compareTo(first) >= 0 && phones[i].getAccountNumber().compareTo(last) <= 0) {
                System.out.println(phones[i]);
            }
        }
    }
}
