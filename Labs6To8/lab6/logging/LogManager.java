package logging;

import java.io.IOException;
import java.util.logging.*;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class LogManager {
    private static final Logger logger = Logger.getLogger("CoffeeTruckLogger");

    static {
        try {
        	FileHandler fileHandler = new FileHandler("C:\\Users\\Maxx\\Desktop\\pp\\lab8\\CoffeeTruck.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);
            
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Помилка під час налаштування логера.", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void logCriticalError(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
        sendEmailAlert(message, throwable);
    }

    private static void sendEmailAlert(String message, Throwable throwable) {
        String to = "vivabiba1337@gmail.com";
        String from = "maxkalan2006@gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, "ejbw nibq wubj owww"); // Введіть пароль програми;
            }
        });

        try {
            MimeMessage email = new MimeMessage(session);
            email.setFrom(new InternetAddress(from));
            email.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            email.setSubject("Критична помилка в CoffeeTruck");
            email.setText("Критична помилка:\n" + message + "\n" + throwable);

            System.out.println("Відправка електронної пошти...");
            Transport.send(email);
            System.out.println("Електронне повідомлення відправлено.");
        } catch (MessagingException mex) {
            logger.log(Level.SEVERE, "Помилка під час відправлення e-mail.", mex);
        }
    }
}
