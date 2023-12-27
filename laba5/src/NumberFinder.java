import java.util.regex.*;
public class NumberFinder {
    public static void main(String[] args){
        String text = "The price of 21 and 21,1 the product is $19.99 for 2 month ";

        try {
            Pattern pattern = Pattern.compile("\\d+((\\.|,)\\d+)?");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch (PatternSyntaxException e){
            System.out.println("Ошибка в синтаксисе");
        }
    }
}

