import java.util.Arrays;

public class ArrayAverage {
    public static void main(String[] args){
        //String[] arr = {"a", "2", "3", "4", "5"};
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        try{
            for(int i = 0; i < arr.length ; i++)
                sum += Integer.parseInt(String.valueOf(arr[i]));
            System.out.println(sum/arr.length);
            System.out.println(Arrays.toString(arr));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Out of Bounds");
        } catch (NumberFormatException e){
            System.out.println("Not a Number");
        }
    }
}
