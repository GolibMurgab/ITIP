public class ArrayMax extends Thread{
    int max;
    int[] a;
    public ArrayMax(int[] a){
        this.a = a;
    }

    @Override
    public void run(){
        max = a[0];
        for(int i: a)
            if(i > max)
                max = i;
    }

    public int getMax(){
        return max;
    }
}
