public class ArraySum extends Thread{
    int[] a;
    int firstIndex;
    int lastIndex;
    int sum;
    public ArraySum(int[] a, int f, int l){
        this.a = a;
        firstIndex = f;
        lastIndex = l;
    }

    @Override
    public void run(){
        sum = 0;
        for(int i = firstIndex; i < lastIndex; i++)
            sum += a[i];
    }

    public int getSum() {
        return sum;
    }
}
