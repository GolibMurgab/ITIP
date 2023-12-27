import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------1");
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did " +
                "this task not by yourself, you have to understand " +
                "every single line of code."));

        System.out.println("-----------2");
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println("-----------3");
        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println("-----------4");
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        int[] a1 = {1, -3, 2};
        int[] a2 = {2, 5, 2};
        int[] a3 = {1, -6, 9};
        System.out.println("-----------5");
        System.out.println(countRoots(a1));
        System.out.println(countRoots(a2));
        System.out.println(countRoots(a3));

        String[][] s1 = {{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4",},
                {"Pear", "Shop2", "Shop4"}};
        String[][] s2 = {{"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}};
        System.out.println("-----------6");
        System.out.println(Arrays.toString(salesData(s1)));
        System.out.println(Arrays.toString(salesData(s2)));

        System.out.println("-----------7");
        System.out.println(validSlit("apple eagle goat egg trump"));
        System.out.println(validSlit("cat dog goose fish"));

        int[] a4 = {3, 1, 0, 2, 7, 5};
        int[] a5 = {1, 2, 3, 4, 5};
        int[] a6 = {1, 2, -6, 10, 3};
        System.out.println("-----------8");
        System.out.println(waveForm(a4));
        System.out.println(waveForm(a5));
        System.out.println(waveForm(a6));

        System.out.println("-----------9");
        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));

        int[][] a7 = {{1, 2, 3, 4, 5}, {6, 7, 8, 29, 10}, {5, 5, 5, 5, 35}, {7, 4, 3, 14, 2}, {1, 0, 11, 10, 1}};
        int[][] a8 = {{6, 4, 19, 0, 0}, {81, 25, 3, 1, 17}, {48, 12, 60, 32, 14}, {91, 47, 16, 65, 217}, {5, 73, 0, 4, 21}};
        System.out.println("-----------10");
        System.out.println(Arrays.deepToString(dataScience(a7)));
        System.out.println(Arrays.deepToString(dataScience(a8)));
    }

    public static String replaceVovels(String s){
        String a = "";
        char[] dictionary = {'a', 'o', 'e', 'u', 'i'};
        for(int i = 0; i < s.length(); i++){
            int z = 0;
            for(char j : dictionary){
                if(s.toLowerCase().charAt(i) == j){
                    a += "*";
                    z = 1;
                }
            }
            if (z == 0){
                a += s.charAt(i);
            }
        }
        return a;
    }

    public static String stringTransform(String s){
        String sDouble = "";
        for(int i = 0; i < s.length(); i++){
            if((i != s.length() - 1) && (s.charAt(i) == s.charAt(i + 1))){
                sDouble = sDouble + "Double" + (s.toUpperCase().charAt(i));
                i++;
            }else {
                sDouble += s.charAt(i);
            }
        }
        return sDouble;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        int min1 = Math.min(Math.min(a, b), c);
        int min2 = a + b + c - min1 - Math.max(Math.max(a, b), c);
        return ((min1 <= Math.min(w, h)) && (min2 <= Math.max(w, h)));
    }

    public static boolean numCheck(int x){
        int s = x % 10;
        while(x != 0){
            s = s + (x % 10) * (x % 10);
            x /= 10;
        }
        return s % 2 == 0;
    }

    public static int countRoots(int[] a){
        int D = a[1] * a[1] - 4 * a[0] * a[2];
        if(D < 0){
            return 0;
        }
        if(D == 0){
            return (-a[1]/(2f*a[0])) % 1 == 0 ? 1: 0;
        }
        int b = ((-a[1] + Math.sqrt(D))/(2f*a[0])) % 1 == 0 ? 1: 0;
        b += ((-a[1] - Math.sqrt(D))/(2f*a[0])) % 1 == 0 ? 1: 0;
        return b;
    }

    public static String[] salesData(String[][] sales){
        int max = 0;
        for (String[] i: sales){
            if (i.length > max){
                max = i.length;
            }
        }
        ArrayList <String> mostSale = new ArrayList<>();
        for(String[] i: sales){
            if(max == i.length){
                mostSale.add(i[0]);
            }
        }
        String[] array = new String[mostSale.size()];
        return mostSale.toArray(array);
    }

    public static String valid(String[] s, String result){
        if (s.length == 0){
            return result;
        }
        //"apple eagle egg goat
        for(int i = 0; i < s.length; i++){
            if((result == "") || (result.charAt(result.length() - 1) == s[i].charAt(0))){
                String[] sNew = new String[s.length - 1]; // Array which will contain the result.
                System.arraycopy(s, 0, sNew, 0, i);
                System.arraycopy(s, i + 1, sNew, i, s.length - i - 1);

                if(result == ""){
                    result += s[i];
                }else {
                    result = result + " " + s[i];
                }

                String res = valid(sNew, result);
                return res;
            }
        }
        return "";
    }

    public static boolean validSlit(String s){
        return valid(s.split(" "), "").length() == s.length();
    }

    public static boolean waveForm(int[] a) {
        boolean l = true;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < a[i - 1]) {
                if (a[i] > a[i + 1]) {
                    l = false;
                }
            } else {
                if (a[i] < a[i + 1]) {
                    l = false;
                }
            }
        }
        return l;
    }

    public static char commonVovel(String s){
        char[] vovels = {'a', 'o', 'e', 'i', 'y', 'u'};
        char maxVovel = vovels[0];
        int maxCount = 0;
        for(char i : vovels){
            int count = 0;
            for(char j : s.toLowerCase().toCharArray()){
                if(j == i){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                maxVovel = i;
            }
        }
        return maxVovel;
    }

    public static int[][] dataScience(int[][] a){
        for(int i = 0; i < a.length; i++){
            int sum = 0;
            for(int j = 0; j < a.length; j++){
                if(j != i) {
                    sum += a[j][i];
                }
            }
            a[i][i] = Math.round(sum / (a.length - 1f));
        }
        return a;
    }
}