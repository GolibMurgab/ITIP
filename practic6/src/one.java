public class one {
    public static void main(String[] args){
        System.out.println(hiddenAny("1 2 -3 4 5"));
    }
    public static String hiddenAny(String s){
        String[] a = s.split(" ");
        Integer min = Integer.parseInt(a[0]);
        Integer max = min;
        for(int i = 0; i < a.length; i++){
            max = Math.max(max, Integer.parseInt(a[i]));
            min = Math.min(min, Integer.parseInt(a[i]));
        }
        return max + " " + min;
    }
}
