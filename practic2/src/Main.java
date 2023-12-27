import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println(triangleType(5,5,5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(3,4,5));
        System.out.println(triangleType(1,1,5));

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9   ));

        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(howManyItems(45, 1.8f, 1.9f));
        System.out.println(howManyItems(100, 2f, 2f));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));

        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barak Obama"));

        int[] x1 = {44, 32, 86, 19};
        int[] x2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(x1));
        System.out.println(differenceEvenOdd(x2));

        int[] x3 = {1, 2, 3, 4, 5};
        int[] x4 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(x3));
        System.out.println(equalToAvg(x4));

        int[] x5 = {1, 2, 3};
        int[] x6 = {3, 2, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(x5)));
        System.out.println(Arrays.toString(indexMult(x6)));

        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println(botHelper("Help, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));

        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand every single line of code."));
    }
    public static float convert(int x){
        return x * 3.785f;
    }

    public static int fitCalc(int x, int y){
        return x * y;
    }

    public static int containers(int x, int y, int z){
        return x * 20 + y * 50 + z * 100;
    }

    public static String triangleType(int x, int y, int z){
        if ((x + y < z) || (x + z < y) || (y + z < x)){
            return "not a triangle";
        }
        else if ((x == y) && (x == z)){
            return "isosceles";
        }
        else if ((x == y) || (y == z) || (x == z)){
            return "equilateral";
        }
        else
            return "different-sided";
    }

    public static int ternaryEvaluation (int x, int y){
        return x > y ? x: y;
    }

    public static int howManyItems(int x, float y, float z){
        return (int) (x/y/z/2);
    }

    public static int factorial (int x){
        int i;
        int z = 1;
        for (i = 1; i <= x; i++){
            z *= i;
        }
        return z;
    }

    public static int gcd (int x, int y){
        if ((x == 0)||(y==0)){
            return 0;
        }
        while ((x != 0) && (y != 0)){
            if (x >= y){
                x = x % y;
            }
            else {
                y = y % x;
            }
        }
        return x + y;
    }
    public static int ticketSaler(int x, int y){
        return x * y * 18/25;
    }

    public static int tables(int x, int y){
        if (x - y*2 > 0){
            return (x-y*2)/2 + 1;
        }
        else{
            return 0;
        }
    }

    public static boolean duplicateChars(String x){
        int n = x.length();
        for(int i = 0; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                if (x.toLowerCase().charAt(i) == x.toLowerCase().charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static String getInitials(String x){
        String z = "";
        for(int i = 0; i < x.length(); i++){
            if ((i == 0) || (x.charAt(i-1) == ' ')){
                z += x.charAt(i);
            }
        }
        return z;
    }

    public static int differenceEvenOdd(int[] x){
        int even = 0;
        int odd = 0;
        for (int i : x) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        return Math.abs(even - odd);
    }

    public static boolean equalToAvg(int[] x){
        int Sum = 0;
        for(int i : x){
            Sum += i;
        }
        double Avg = (double) Sum /x.length;
        for(int i : x){
            if(i == Avg){
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] x){
        for(int i = 0; i < x.length; i++){
            x[i] = x[i] * i;
        }
        return x;
    }

    public static String reverse(String x){
        String n = "";
        for(int i = x.length() -1; i >= 0; i--){
            n += x.charAt(i);
        }
        return n;
    }

    public static int Tribonacci(int n){
        int x1 = 0;
        int x2 = 0;
        int x3 = 1;
        int f = 0;
        while (n != 3){
            f = x1 + x2 + x3;
            x1 = x2;
            x2 = x3;
            x3 = f;
            n--;
        }
        return f;
    }

    public static String pseudoHash(int n){
        String dictionary = "abcdefghijklmnopqrstuwxyz1234567890";
        String s = "";
        while(n!=0){
            Random r = new Random();
            s += dictionary.charAt(r.nextInt(35));
            n--;
        }
        return s;
    }

    public static String botHelper(String s){
        String[] words = s.split(" ");
        for(String i: words){
            if(i.equalsIgnoreCase("help")){
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String a1, String a2){
        char[] c1 = a1.toCharArray();
        char[] c2 = a2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.toString(c1).equals(Arrays.toString(c2));
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
}