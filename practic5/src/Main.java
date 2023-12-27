import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println("---------------2");
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "H4"));
        System.out.println(spiderVsFly("A4", "C2"));


        System.out.println("---------------3");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println("---------------4");
        String[] s4 = {"cat", "create", "sat"};
        String[] s5 = {"trance", "recant"};
        String[] s6 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(s4, "caster"));
        System.out.println(totalPoints(s5, "recant"));
        System.out.println(totalPoints(s6, "tossed"));

        System.out.println("---------------5");
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {1, 2, 3, 7, 9};
        int[] a3 = {10, 9, 7, 2, 8};
        int[] a4 = {1, 6, 5, 4, 8, 2, 3, 7};
        System.out.println(Arrays.deepToString(sumsUp(a1).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(a2).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(a3).toArray()));
        System.out.println(Arrays.deepToString(sumsUp(a4).toArray()));

        System.out.println("---------------6");
        String[] s1 = {"95%", "83%", "90%", "87%", "88%", "93%"};
        String[] s2 = {"10%"};
        String[] s3 = {"53%", "79%"};
        System.out.println(takeDownAverage(s1));
        System.out.println(takeDownAverage(s2));
        System.out.println(takeDownAverage(s3));

        System.out.println("---------------7");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));

        System.out.println("---------------8");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));

        System.out.println("---------------9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println("---------------10");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));

//        System.out.println(timeDifference("Los Angeles", "April 1, 2011 00:23", "Canberra")); //ситуация, когда по времени плюс, но ничего в дате не меняется
//        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); //новый день
//        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); //новый месяц 31
//        System.out.println(timeDifference("London", "July 30, 1983 23:01", "Rome")); //остаток в том же месяце при 31 днях
//        System.out.println(timeDifference("London", "June 30, 1983 23:01", "Rome")); // переход на новый месяц при 30 днях
//        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); //новый год
        System.out.println(timeDifference("London", "February 29, 2000 23:40", "Rome")); //новый високосный месяц
        System.out.println(timeDifference("Moscow", "February 28, 2000 23:40", "Tehran")); //старый високосный месяц февраль
//        System.out.println(timeDifference("Rome", "February 28, 2001 23:40", "Moscow")); // новый месяц после февраля в невисокосный год
//
//        System.out.println(timeDifference("Buenos Aires", "April 2, 2011 01:23", "Caracas")); //старый день
//        System.out.println(timeDifference("New Delhi", "June 1, 1983 01:01", "Tehran")); //старый месяц 31
//        System.out.println(timeDifference("Rome", "May 1, 2000 00:40", "London")); // возврат на 30 число
//        System.out.println(timeDifference("Beijing", "January 1, 1977 1:40", "New Delhi")); //старый год
        System.out.println(timeDifference("Rome", "March 1, 2000 00:40", "London")); //возврат на 29 февраля
//        System.out.println(timeDifference("Rome", "March 1, 2001 00:40", "London")); //возврат на  28 февраля
//        System.out.println(timeDifference("Rome", "May 1, 2000 05:40", "London")); // ничего не происходит
        }

    public static boolean sameLetterPattern(String a, String b){
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int difference = aChar[0] - bChar[0];
        if(aChar.length != bChar.length)
            return false;
        for(int i = 0; i < aChar.length; i++){
            if(aChar[i] - bChar[i] != difference)
                return false;
        }
        return true;
    }

    //222222222222222222222222222222222222222222
    public static String spiderVsFly(String spider, String fly){
        int spiderX = Character.getNumericValue(spider.charAt(1));
        int spiderRadial = spider.charAt(0) - 65;
        int flyX = Character.getNumericValue(fly.charAt(1));
        int flyRadial = fly.charAt(0) - 65;

        int way;
        String result = "";
        int move;

        if(Math.floorMod((spiderRadial - flyRadial), 8) <= 4)
            move = -1;
        else
            move = 1;

        if(Math.abs(spiderRadial - flyRadial)<=2 || Math.abs(spiderRadial - flyRadial) >=6)
            way = 1;
        else
            way = 0;

        while (spiderX != flyX || spiderRadial != flyRadial){
            if(way == 1) {
                if (spiderX > flyX) {
                    result = result + (char)(spiderRadial + 65) + spiderX  + "-";
                    spiderX--;
                } else if (spiderRadial != flyRadial) {
                    result = result + (char)(spiderRadial + 65) + spiderX  + "-";
                    spiderRadial = Math.floorMod((spiderRadial + move), 8);
                }else {
                    result = result + (char)(spiderRadial + 65) + spiderX  + "-";
                    spiderX++;
                }
            } else {
                if(spiderX != 0  && spiderRadial != flyRadial){
                    result = result + (char)(spiderRadial + 65) + spiderX  + "-";
                    spiderX--;
                } else if(spiderX == 0){
                    spiderRadial = flyRadial;
                    result += "A" + spiderX  + "-";
                    spiderX++;
                } else {
                    result = result + (char)(spiderRadial + 65) + spiderX  + "-";
                    spiderX++;
                }
            }
        }
        return result + fly;
    }

    public static int digitsCount(long n){
        if(n / 10 == 0)
            return 1;
        return 1 + digitsCount(n/10);
    }

    //4444444444444444444444444
    public static int totalPoints(String[] answer, String word){
        int len;
        int result = 0;
        for(String i: answer){
            len = i.length();
            for(char j: i.toCharArray()){
                if (word.length() - word.replace(String.valueOf(j), "").length() <
                        i.length() - i.replace(String.valueOf(j), "").length()) {
                    len = 0;
                    break;
                }
            }
            if(len == 3)
                result += 1;
            else if (len == 4)
                result += 2;
            else if (len == 5)
                result += 3;
            else if (len == 6)
                result += 54;
        }
        return result;
    }

    //5555555555555555555555555 !!!!
    public static ArrayList<int[]> sumsUp(int[] a){
        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<Integer> gap = new ArrayList<>();
        ArrayList<Integer> exclusion = new ArrayList<>();
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] + a[j] == 8 && !exclusion.contains(j)){
                    gap.add(Math.abs(j - i));
                    exclusion.add(j);
                    result.add(new int[]{Math.min(a[i], a[j]), Math.max(a[i], a[j])});
                }
            }
        }
        for(int i = 0; i < gap.size(); i++) {
            for (int j = i + 1; j < gap.size(); j++) {
                if(gap.get(i) > gap.get(j)){
                    int b = gap.get(i);
                    gap.set(i, gap.get(j));
                    gap.set(j, b);
                    int[] c = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, c);
                }
            }
        }
        return result;
    }

    //66666666666666666666666666
    public static String takeDownAverage(String[] interest){
        int s = 0;
        int length = interest.length;
        for(String j: interest)
            s += Integer.parseInt(j.split("%")[0]);

        int result = Math.round((length + 1)*((float) s/length - 5) - s);
        return result + "%";
    }

    //777777777777777777777777777
    public static String caesarCipher(String mode, String row, int shift){
        int n;
        String result = "";
        if(mode.equals("encode"))
            n = shift;
        else
            n = -shift;
        for(char i: row.toLowerCase().toCharArray()){
            int letterCode = i + n;
            if(i < 96 || i > 122)
                result += (char) (i);
            else if(letterCode - 96 <= 0)
                result += (char) (letterCode + 26);
            else if(letterCode - 96 > 26)
                result += (char) (letterCode - 26);
            else
                result += (char) (letterCode);
        }
        if (mode.equals("decode"))
            return result.toLowerCase();
        return result.toUpperCase();
    }

    //888888888888888888888888888
    public static int setSetup(int n, int k){
        if(k == 1)
            return n;
        return (n - k + 1) * setSetup(n, k - 1);
    }


    //999999999999999999999999999
    public static String timeDifference(String from, String time, String where){
        HashMap<String, int[]> month = new HashMap<>(){{
            put("January", new int[]{1, 31, 31, 28});
            put("February", new int[]{2, 28, 31, 31});
            put("March", new int[]{3, 31, 28, 30});
            put("April", new int[]{4, 30, 31, 31});
            put("May", new int[]{5, 31, 30, 30});
            put("June", new int[]{6, 30, 31, 31});
            put("July", new int[]{7, 31, 30, 31});
            put("August", new int[]{8, 31, 31, 30});
            put("September", new int[]{9, 30, 31, 31});
            put("October", new int[]{10, 31, 30, 30});
            put("November", new int[]{11, 30, 31, 31});
            put("December", new int[]{12, 31, 30, 31});
        }};
        HashMap<String, int[]> GMT = new HashMap<>(){{
            put("Los Angeles", new int[]{-8, 0});
            put("New York", new int[]{-5, 0});
            put("Caracas", new int[]{-4,-30});
            put("Buenos Aires", new int[]{-3, 0});
            put("London", new int[]{0, 0});
            put("Rome", new int[]{1, 0});
            put("Moscow", new int[]{3, 0});
            put("Tehran", new int[]{3, 30});
            put("New Delhi", new int[]{5, 30});
            put("Beijing", new int[]{8, 0});
            put("Canberra", new int[]{10, 0});
        }};
        String result = "";
        String[] data = time.split(" ");
        int[] diff = new int[]{GMT.get(where)[0] - GMT.get(from)[0], GMT.get(where)[1] - GMT.get(from)[1]};
        //"Buenos Aires", "April 2, 2011 01:23", "Caracas"
        String[] clock = data[3].split(":");
        int minutes = Integer.parseInt(clock[1]) + diff[1];
        int hours = Integer.parseInt(clock[0]) + diff[0] + minutes/60;
        if(minutes < 0)
            hours -= 1;
        if(Math.floorMod(hours,24) < 10)
            result += "0" + Math.floorMod(hours,24) + ":";
        else
            result += Math.floorMod(hours,24) + ":";
        if(Math.floorMod(minutes, 60) < 10)
            result += "0" + Math.floorMod(minutes, 60);
        else
            result += Math.floorMod(minutes, 60);

        int year = Integer.parseInt(data[2]);
        int visokos = 0;
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            visokos = 1;
        }
        int day = Integer.parseInt(data[1].replace(",", "")) + hours/24;
        if(hours < 0) {
            day -= 1;
        }
        int mon = month.get(data[0])[0];
        if(visokos == 1 && mon == 2)
            mon = mon + (day-1)/29;
        else
            mon = mon + (day-1)/month.get(data[0])[1];
        if(day <= 0)
            mon -= 1;


        year = year + mon/12;
        if(mon == 0) {
            year -= 1;
            return year + "-" + "12" + "-" + 31 + " " +result;
        }
        if(mon % 12 < month.get(data[0])[0] && mon != 13)
            if(visokos == 1 && month.get(data[0])[0] == 3)
                return year + "-" + mon % 12 + "-" + 29 + " " + result;
            else
                return year + "-" + mon % 12 + "-" + month.get(data[0])[2] + " " + result;
        else if (mon % 12 > month.get(data[0])[0] || mon == 13)
            return year + "-" + mon % 12 + "-" + 1 + " " + result;
        else if(mon == month.get(data[0])[0])
            return year + "-" + mon + "-" + day  + " " + result;
        else
            return year + "-" + mon + "-" + day % month.get(data[0])[1]  + " " + result;
    }

    //101010010101010101010101010
    public static boolean isNew(int a){
        ArrayList<Integer> digits = new ArrayList<>();
        for(int i : Integer.toString(a).toCharArray())
            digits.add(Character.getNumericValue(i));

        int c;
        for(int i = 0; i < digits.size(); i++)
            for (int j = i; j < digits.size(); j++)
                if (digits.get(i) > digits.get(j) && !(digits.get(j) == 0 && (i == 0))) {
                    c = digits.get(i);
                    digits.set(i, digits.get(j));
                    digits.set(j, c);
                }
        int b = 0;
        for (Integer digit : digits)
            b = b * 10 + digit;
        return b == a;
    }
}