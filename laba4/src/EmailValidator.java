import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class EmailValidator {
    public static void validateEmail(String email) throws CustomEmailFormatException {
        if (!email.contains("@"))
            throw new CustomEmailFormatException("Отсутствует символ @");
        else if (email.replaceFirst("@", "").contains("@"))
            throw new CustomEmailFormatException("2 и более символа @");

        else if (email.contains("!") ||
                email.contains("#") ||
                email.contains("$") ||
                email.contains("%") ||
                email.contains("&") ||
                email.contains("~") ||
                email.contains("=") ||
                email.contains("'") ||
                email.contains(" ") ||
                email.contains(":")
        )
            throw new CustomEmailFormatException("Запрещенные символы !, #, $, %, &, ~, =, ', : и пробел");

        else if (email.split("@")[0].isEmpty() || email.split("a")[0].charAt(0) == '.')
            throw new CustomEmailFormatException("Неправильный логин");

        else if (email.split("@")[1].isEmpty() ||
                !email.split("@")[1].contains(".") ||
                email.split("@")[1].charAt(0) == '.')
            throw new CustomEmailFormatException("Неправильный почтовый домен");

        else if (email.contains(".."))
            throw new CustomEmailFormatException("Две или более точки подряд");
    }

    public static void main(String[] args){
        try{
            validateEmail("sobaksobaka@!..ru");
            System.out.println("Email корректный");
        } catch (CustomEmailFormatException e){
            try {
                FileWriter writer = new FileWriter("LogException.txt", true);
                writer.write(e.getMessage() + " " + LocalDateTime.now() + "\n");
                writer.close();
            }catch (IOException exception){
                System.out.println("Не удалось сохранить ошибку");
            }
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}