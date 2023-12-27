import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PasswordCheck {
    public static void main(String[] args){
        String password1 = "1soeejjadhfe";
        String password2 = "1soeMejjadhfe";
        try{
            Pattern pattern = Pattern.compile("^(?=\\w*[A-Z])(?=\\w*[0-9])\\w{8,16}$");
            Matcher matcher1 = pattern.matcher(password1);
            Matcher matcher2 = pattern.matcher(password2);
            System.out.println(matcher1.find());
            System.out.println(matcher2.find());
        } catch (PatternSyntaxException e){
            System.out.println("Ошибка в синтаксисе" + e);
        }
    }
}
