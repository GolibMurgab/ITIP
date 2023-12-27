import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------1");
        System.out.println(hiddenAnagram(new String[]{"My world evolves in a beautiful space called Tesh.", "sworn love lived"}));
        System.out.println(hiddenAnagram(new String[]{"An old west action hero actor", "Clint Eastwood"}));
        System.out.println(hiddenAnagram(new String[]{"Mr. Mojo Rising could be a song title", "Jim Morrison"}));
        System.out.println(hiddenAnagram(new String[]{"Banana? margaritas", "ANAGRAM"}));
        System.out.println(hiddenAnagram(new String[]{"D  e b90it->?$ (c)a r...d,,#~", "bad credit"}));
        System.out.println(hiddenAnagram(new String[]{"Bright is the moon", "Bongo mirth"}));

        System.out.println("--------------2");
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));

        System.out.println("--------------3");
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        System.out.println("--------------4");
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45));
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45));
        System.out.println(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20));
        System.out.println(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10));
        System.out.println(twoProduct(new int[]{100, 12, 4, 1, 2}, 15));

        System.out.println("--------------5");
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));

        System.out.println("--------------6");
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println("--------------7");
        System.out.println(pilishString("33314444"));
        System.out.println(pilishString("TOP"));
        System.out.println(pilishString("X"));
        System.out.println(pilishString(""));
        System.out.println(pilishString("HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHA" +
                "NICSANDALLTHESECRETSOFTHEUNIVERSE"));
        System.out.println("FORALOOP    ");
        System.out.println(pilishString("CANIMAKEAGUESSNOW"));

        System.out.println("--------------8");
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));

        System.out.println("--------------9");
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println("--------------10");
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println(findLCS("abcd", "bd"));

    }
    //111111111111111111111111
    public static String hiddenAnagram(String[] data){
        String word = data[0].replaceAll("[^A-Za-z]", "").toLowerCase();
        char[] temp = data[1].replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(temp);
        String key = new String(temp);
        for(int i = 0; i < word.length() - key.length() + 1; i++){
            String answer = word.substring(i, i + key.length());
            temp = answer.toCharArray();
            Arrays.sort(temp);
            if(key.equals(new String(temp)))
                return answer;
        }
        return "notfound";
    }
    //222222222222222222222222
    public static String[] collect(String s, int n){
        ArrayList<String> r = new ArrayList<>();
        ArrayList<String> result = collectR(s, n, r);
        Collections.sort(result);
        return result.toArray(new String[]{});
    }

    public static ArrayList<String> collectR(String s, int n, ArrayList<String> r){
        if(s.length()/n == 0)
            return r;
        r.add(s.substring(0, n));
        return collectR(s.substring(n), n, r);
    }

    //333333333333333333333333
    public static String nicoCipher(String message, String key){
        int size = (int) Math.ceil(message.length()/(double)key.length());
        int j =0;
        int i = 0;
        char[][] a = new char[size][key.length()];
        int probel = size * key.length() - message.length();
        char[] keyChar = key.toCharArray();
        String result = "";
        if(probel != 0) {
            while (probel != 0){
                message += " ";
                probel--;
            }
        }
        for(i = 0; i < size; i++)
            a[i] = message.substring(i * key.length(), (i + 1) * key.length()).toCharArray();

        for(i = 0; i < key.length(); i++){
            int index = i;
            char min = keyChar[i];
            for(j = i; j < key.length(); j++){
                if(min > keyChar[j]){
                    min = keyChar[j];
                    index = j;
                }
            }
            char c = keyChar[i];
            keyChar[i] = keyChar[index];
            keyChar[index] = c;

            for(j = 0; j < size; j++){
                char b = a[j][i];
                a[j][i] = a[j][index];
                a[j][index] = b;
            }
        }
        for(i = 0; i < size; i++)
            result += new String(a[i]);
        return result;
    }

    //444444444444444444444444
    public static ArrayList<Integer> twoProduct(int[] a, int n){
        ArrayList<Integer> result = new ArrayList<>();
        int gap = a.length;
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] * a[j] == n && gap > j - i){
                    gap = j - i;
                    if(result.isEmpty()){
                        result.add(a[i]);
                        result.add(a[j]);
                    } else{
                        result.set(0, a[i]);
                        result.set(1, a[j]);
                    }
                }
            }
        }
        return result;
    }

    //555555555555555555555555
    public static int[] isExact(int g){
        return isExc(g, 1, 1);
    }
    public static int[] isExc(int g, int n, int i){
        if(g == n)
            return new int[]{g, i};
        else if(g > n){
            i++;
            return isExc(g, n*i, i);
        } else
            return new int[]{};
    }

    //666666666666666666666666666 a.b(c)
    public static  String fractions(String s){
        String[] notRepeat = s.split("\\(")[0].split("\\.");
        String repeat = s.split("\\(")[1].split("\\)")[0];
        int cSize = repeat.length();
        int bSize = notRepeat.length == 1 ? 0 : notRepeat[notRepeat.length - 1].length();
        int a = Integer.parseInt(notRepeat[0]);
        int b = bSize == 0 ? 0: Integer.parseInt(notRepeat[1]);
        int c = Integer.parseInt(repeat);

        int x = (int) (a * Math.round(Math.pow(10, bSize)) * Math.round(Math.pow(10, cSize)) +
                b * Math.round(Math.pow(10, cSize)) + c - a * Math.round(Math.pow(10, bSize))) - b;
        int y = (int) (Math.round(Math.pow(10, bSize)) * (Math.round(Math.pow(10, cSize)) -1));

        return "" + x / nod(y, x) + "/" + y / nod(y, x);
    }

    public static int nod(int a, int b){
        while(b != 0){
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
    //77777777777777777777777777
    public static String pilishString(String word){
        int[] pi = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
        String result = "";
        for(int a: pi){
            if(word.isEmpty())
                return result;
            if(word.length() - a < 0){
                return result + word + word.substring(word.length() - 1).repeat(a - word.length());
            }

            result += word.substring(0, a) + " ";
            word = word.substring(a);
        }
        return result;
    }
    //88888888888888888888888888
    public static double generateNonconsecutive(String s) {
        s = s.replaceAll("\\s+", "");
        if(s.length() - s.replaceAll("\\(","").length() !=
                s.length() - s.replaceAll("\\)","").length())
            throw new RuntimeException("Не хватает скобок");
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
                        (index - 1 > 1 && !Character.isDigit(s.charAt(index - 2)) &&
                                (s.charAt(index - 1) == '-') &&
                                s.charAt(index - 2) != ')'))
                    numbers.push(-num);
                else
                    numbers.push(num);
            }
            else if (c == '(') {
                operators.push(c);
            }
            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    double result = calculate(operators.pop(), numbers.pop(), numbers.pop());
                    if (Double.isNaN(result))
                        throw new RuntimeException("Деление на ноль");
                    numbers.push(result);
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
                    if (Double.isNaN(result))
                        throw new RuntimeException("Деление на ноль");
                    numbers.push(result);
                }
                if (i != 0 &&
                        s.charAt(i - 1) != '(' &&
                        s.charAt(i - 1) != '+' &&
                        s.charAt(i - 1) != '*' &&
                        s.charAt(i - 1) != '-' &&
                        s.charAt(i - 1) != '/'
                )
                    operators.push(c);
                else if(c != '-')
                    throw new RuntimeException("Неправильно введены операции");
            } else
                throw new RuntimeException("Недопустимые символ" + c);
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
    //99999999999999999999999999
    public static String isValid(String s){
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        int k = 1;
        int z = 1;
        HashMap<Integer, Integer> countSymbols = new HashMap<>();
        for(int i = 0; i < s.length() - 1; i++){
            if(sChar[i] == sChar[i+1]){
                k++;
            }else{
                if(countSymbols.get(k) == null)
                    z=1;
                else
                    z = countSymbols.get(k) + 1;
                countSymbols.put(k, z);
                k = 1;
            }
        }
        countSymbols.put(k, z + 1);
        if(countSymbols.size() > 2)
            return "NO";
        else {
            ArrayList<Integer> a = new ArrayList<>(countSymbols.keySet());
            if(a.size() == 1) {
                return "YES";
            }
            Integer maxKey = Math.max(a.get(0),a.get(1));
            Integer minKey = Math.min(a.get(0),a.get(1));
            if(countSymbols.get(maxKey) == 1 && Math.abs(maxKey - minKey) == 1)
                return "YES";
            else
                return "NO";
        }
    }

    //10000000000000000000000000000

    public static String findLCS(String s1, String s2) {
        String[][] result = new String[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length()+1; i++) {
            result[i][0] = "";
        }
        for (int i = 0; i < s2.length()+1; i++) {
            result[0][i] = "";
        }
        for (int i = 1; i < s1.length()+1; i++) {
            char a = s1.charAt(i - 1);
            for (int j = 1; j < s2.length()+1; j++) {
                char b = s2.charAt(j - 1);
                if (a == b) {
                    result[i][j] = result[i - 1][j - 1] + a;
                } else if (result[i - 1][j].length() > result[i][j - 1].length())
                    result[i][j] = result[i-1][j];
                else
                    result[i][j] = result[i][j-1];
            }
        }
        return result[s1.length()][s2.length()];
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
