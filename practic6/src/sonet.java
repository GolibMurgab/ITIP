import java.util.Stack;

public class sonet {
    public static void main(String[] args) {
        System.out.println(calculate1("-3 + 5 * (2 + 6)"));
        System.out.println("");
        System.out.println(calculate1("3 + 5 * (2 * (12 / (6 + 6)) - 6)"));
    }
    public static double calculate1(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Character> operators = new Stack<>();
        Stack<Double> numbers = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int index = i;
                double num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                if((index == 1 && s.charAt(0) == '-') ||
                        (index - 1 > 1 && !Character.isDigit(s.charAt(index - 2)) && s.charAt(index - 2) != ')'
                                && (s.charAt(index - 1) == '-')))
                    numbers.push(-num);
                else
                    numbers.push(num);
                System.out.println(num);
            }
            else if (c == '(') {
                operators.push(c);
                System.out.println(c);
            }
            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    System.out.println("----------");
                    System.out.println(operators.peek() + "n");
                    System.out.println(numbers.peek() + "n");
                    double result = calculate(operators.pop(), numbers.pop(), numbers.pop());
                    if (Double.isNaN(result)) {
                        throw new RuntimeException("Деление на ноль");
                    }
                    numbers.push(result);
                    System.out.println(result);
                }
                if (!operators.isEmpty())
                    operators.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() &&
                        !(operators.peek() == '(' || operators.peek() == ')') &&
                        !((c == '*' || c == '/') && (operators.peek() == '+' || operators.peek() == '-'))&&
                                s.charAt(i - 1) != '+' &&
                                s.charAt(i - 1) != '*' &&
                                s.charAt(i - 1) != '-' &&
                                s.charAt(i - 1) != '/'
                ) {
                    double result = calculate(operators.pop(), numbers.pop(), numbers.pop());
                    if (Double.isNaN(result)) {
                        throw new RuntimeException("Деление на ноль");
                    }
                    numbers.push(result);
                }
                if (i != 0 &&
                        s.charAt(i - 1) != '(' &&
                        s.charAt(i - 1) != '+' &&
                        s.charAt(i - 1) != '*' &&
                        s.charAt(i - 1) != '-' &&
                        s.charAt(i - 1) != '/'
                )
                {
                    operators.push(c);
                    System.out.println(c);
                }
                else if(c != '-')
                    throw new RuntimeException("Неправильно введены операции");
            } else
                throw new RuntimeException("Недопустимые символ");
        }
        while (!operators.isEmpty() ) {
            double result = calculate(operators.pop(), numbers.pop(), numbers.pop());
            if (Double.isNaN(result))
                throw new RuntimeException("Деление на ноль");
            numbers.push(result);
        }
        return numbers.pop();
    }
    private static double calculate(char op, double b, double a) {
        if(op == '+')
            return a + b;
        else if(op == '-')
            return a - b;
        else if(op == '*')
            return a * b;
        else if(op == '/'){
            if (b == 0)
                return Double.NaN;
            return a / b;
        }
        return 0.;
    }


    public static String findLCS1(String s1, String s2){
        String result = "";
        int index = 0;
        String sequence = "";
        int pointer = 0;
        for(int i = 0; i < s1.length(); i++){
            boolean find = false;
            for(int j = index; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    find = true;
                    index = j + 1;
                    break;
                }
            }
            if(find){
                sequence += s1.charAt(i);
            }
            if(i == s1.length() - 1){
                if(result.length() < sequence.length())
                    result = sequence;
                sequence = "";
                pointer ++;
                i = pointer;
                index = 0;
            }
        }
        return result;
    }
}
