import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyperLink {
    public static void main(String[] args) {
        String text = "Крутые ссылки на раз два три: www.something.com, google.com/a/, www.genius.com.";

        try {
            Pattern pattern = Pattern.compile("\\b((www\\.)?\\w+\\.com(/[a-z]*)*)\\b");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                String a = "https://" + matcher.group();
                text = text.replace(matcher.group(), a);
            }
            System.out.println(text);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
