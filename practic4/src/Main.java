import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------- 1");
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));


        System.out.println("------------- 2");
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        System.out.println("------------- 3");
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));

        System.out.println("------------- 4");
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println(alphabeticRow("abababa"));


        System.out.println("------------- 5");
        System.out.println(severalInRow("aaabbcdd"));
        System.out.println(severalInRow("vvvvaajaaaaa"));

        System.out.println("------------- 6");
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        System.out.println("------------- 7");
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        System.out.println("------------- 8");
        int[][] a1 = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int[][] a2 = {{2, 7, 3},
                {1, 4, 8},
                {4, 5, 9}};

        System.out.println(shortestWay(a1));
        System.out.println(shortestWay(a2));

        System.out.println("------------- 9");
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println("------------- 10");
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));

    }

    //1
    public static String nonRepeatable(String s) {
        for(int j = 0; j < s.length(); j++){
            for (int i = j + 1; i < s.length(); i++) {
                if ((s.charAt(j) == s.charAt(i))) {
                    return nonRepeatable(s.substring(0, i) + s.substring(i + 1));
                }
            }
        }
        return s;
    }
    //22222222222222222222222222222
    public static ArrayList<String> generateBrackets(int n){
        ArrayList<String> all1 = new ArrayList<>();
        return generate(0, 0, n, "", all1);
    }
    public static ArrayList<String> generate(int left, int right, int n, String result, ArrayList<String> all){
        if(right == n && left == n) {
            all.add(result);
            return all;
        }
        if (left < n)
            generate(left + 1, right, n, result + "(", all);
        if (left > right && right < n)
            generate(left, right + 1, n, result + ")", all);
        return all;
    }

    //33333333333333333333333333333
    public static ArrayList<String> binarySystem(int n){
        ArrayList<String> all = new ArrayList<>();
        return binary(n, "", all);
    }
    public static ArrayList<String> binary(int n, String result, ArrayList<String> all){
        if(result.length() == n){
            all.add(result);
            return all;
        }
        if(result.isEmpty() || '0' != result.charAt(result.length() - 1))
            binary(n, result + "0", all);
        binary(n, result + "1", all);
        return all;
    }

    //4444444444444444444444444444444
    public static String alphabeticRow(String s){
        String maxRow = "";
        for(int i = 0; i < s.length() - 1; i++){
            String row = "" + s.charAt(i);
            for(int j = i; j < s.length() - 1; j++) {
                if ((int) s.charAt(j) == s.charAt(j + 1) - 1) {
                    if (row.length() == 1)
                        row += s.charAt(j + 1);
                    else if (row.charAt(row.length() - 2) + 1 == (int) s.charAt(j))
                        row += s.charAt(j + 1);
                    else
                        break;
                }
                if ((int) s.charAt(j) == s.charAt(j + 1) + 1) {
                    if (row.length() == 1)
                        row += s.charAt(j + 1);
                    else if (row.charAt(row.length() - 2) - 1 == (int) s.charAt(j))
                        row += s.charAt(j + 1);
                    else
                        break;
                }
            }
            if (row.length() > maxRow.length()) {
                maxRow = row;
            }
            i += row.length() - 1;
        }
        return maxRow;
    }

    //555555555555555555555555555
    public static String severalInRow(String s){
        String row = "";
        int x = 1;
        //Считаем число букв и записываем букву с числом
        for(int j = 0; j < s.length() - 1; j++){
            if(s.charAt(j) == s.charAt(j+1)){
                x++;
            } else {
                row = row + s.charAt(j) + x;
                x = 1;
            }
        }

        char[] rowChar = (row + s.charAt(s.length() - 1) + x).toCharArray();
        for(int i = 1; i < rowChar.length - 1; i += 2) {
            int min = i;
            for (int j = i; j < rowChar.length ; j += 2) {
                if (rowChar[j] < rowChar[min]){
                    min = j;
                }
            }
            char a = rowChar[i];
            rowChar[i] = rowChar[min];
            rowChar[min] = a;

            a = rowChar[i - 1];
            rowChar[i - 1] = rowChar[min - 1];
            rowChar[min - 1] = a;
        }
        return new String(rowChar);
    }

    //666666666666666666666666666666
    public static int convertToNum(String s){
        HashMap<String, Integer> numbers = new HashMap<>(){{
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
            put("ten", 10);
            put("elven", 11);
            put("twelve", 12);
            put("thirteen", 13);
            put("fourteen", 14);
            put("fifteen", 15);
            put("sixteen", 16);
            put("seventeen", 17);
            put("eighteen", 18);
            put("nineteen", 19);
            put("twenty", 20);
            put("thirty", 30);
            put("forty", 40);
            put("fifty", 50);
            put("sixty", 60);
            put("seventy", 70);
            put("eighty", 80);
            put("ninety", 90);
            put("hundred", 100);
        }};
        String[] sArray = s.split(" ");
        int result = 0;
        for(int i = 0; i < sArray.length; i++){
            if(i < sArray.length - 1 && sArray[i + 1].equals("hundred")) {
                result = result + numbers.get(sArray[i]) * numbers.get("hundred");
            }else if (!sArray[i].equals("hundred"))
                result += numbers.get(sArray[i]);
        }
        return result;
    }

    //77777777777777777777777777777
    public static String uniqueSubstring(String s){
        String unique = s.substring(0, 1);
        String maxUnique = s.substring(0, 1);
        for(int j = 1; j < s.length() - 1; j++){
            int x = 0;
            for(char i : unique.toCharArray()){
                if(s.charAt(j) == i)
                    x = 1;
            }
            if(x == 0)
                unique += s.charAt(j);
            else
                unique = s.substring(j,j + 1);
            if(unique.length() > maxUnique.length())
                maxUnique = unique;
        }
        return maxUnique;
    }

    //8888888888888888888888888888888
    public static int shortestWay(int[][] a){
        return shortestW(a, a.length - 1, a[0].length - 1);
    }
    public static int shortestW(int[][] a, int n, int m){
        int x = a[n][m];
        if(n == 0 && m == 0)
            return x;
        if(n != 0 && m == 0)
            return x + shortestW(a, n - 1, m);
        if(n == 0)
            return x + shortestW(a, n, m - 1);
        return x + Math.min(shortestW(a, n - 1,  m), shortestW(a, n, m - 1));
    }

    //99999999999999999999999999999999
    public static String numericOrder(String s){
        String[] sub = s.split(" ");
        String[] res = new String[sub.length];
        String result = "";
        for(String i : sub){
            for(int j = 0; j < i.length(); j++){
                if((i.charAt(j) - 48 <= 9)&&(i.charAt(j) - 48 >= 1)){
                    res[i.charAt(j) - 49] = i.substring(0, j) + i.substring(j + 1);
                    break;
                }
            }
        }
        return String.join(" ", Arrays.asList(res));
    }

    //10101010101010010101010101010101010
    public static int switchNums(int a, int b){
        char[] aChar = Integer.toString(a).toCharArray();
        int[] aDigits = new int[aChar.length];
        char[] bChar = Integer.toString(b).toCharArray();
        int[] bDigits = new int[bChar.length];

        for (int i = 0; i < aChar.length; i++)
            aDigits[i] = Character.getNumericValue(aChar[i]);
        for (int i = 0; i < bChar.length; i++)
            bDigits[i] = Character.getNumericValue(bChar[i]);

        Arrays.sort(aDigits);

        int j = aDigits.length - 1;
        int result = 0;
        for(int i = 0; i < bDigits.length; i++){
            if(aDigits[j] > bDigits[i]){
                bDigits[i] = aDigits[j];
                j--;
            }
            result = result * 10 + bDigits[i];
            if(j < 0)
                break;
        }
        return result;
    }
}