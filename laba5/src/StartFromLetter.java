import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StartFromLetter {
    public static void main(String[] args){
        String text = "Something self fun for someone who cares about something";
        String s = "s";

        try{
            Pattern pattern = Pattern.compile("\\b"+s+"\\w+", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find())
                System.out.println(matcher.group());
        } catch (PatternSyntaxException e){
            System.out.println("Ошибка в синтаксисе" + e);
        }
    }
}
