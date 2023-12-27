import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IpCheck {
    public static void main(String[] args){
        String ip1 ="0.0.0.0";
        String ip2 ="255.10.0.1";
        String ip3 ="256.0.0.0";
        String ip4 ="0.010.0.0";
        String b = "(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])";

        try {
            Pattern pattern = Pattern.compile("^("+b+"\\.){3}" + b +"$");
            System.out.println("^("+b+"\\.){3}" + b +"$");
            Matcher matcher1 = pattern.matcher(ip1);
            Matcher matcher2 = pattern.matcher(ip2);
            Matcher matcher3 = pattern.matcher(ip3);
            Matcher matcher4 = pattern.matcher(ip4);
            System.out.println(matcher1.find());
            System.out.println(matcher2.find());
            System.out.println(matcher3.find());
            System.out.println(matcher4.find());
        } catch (PatternSyntaxException e){
            System.out.println("Ошибка в синтаксисе" + e);
        }
    }
}
