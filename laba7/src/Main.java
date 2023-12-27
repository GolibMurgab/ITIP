import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        firstTask();
        secondTask();
        thirdTask();
    }

    public static void firstTask() throws InterruptedException{
        int[] a = {1, 2, 3, 4, 5};
        ArraySum firstHalf = new ArraySum(a, 0, a.length/2);
        ArraySum secondHalf = new ArraySum(a, a.length/2, a.length);
        firstHalf.start();
        secondHalf.start();
        firstHalf.join();
        secondHalf.join();
        System.out.println(firstHalf.getSum() + secondHalf.getSum());
    }

    public static void secondTask() throws InterruptedException{
        int[][] m = {{1, 2, 3}, {4, 5, 6, 4, 1}, {1, 4, 8}, {1, 6}, {4, 3, 6}};
        int[] maximums = new int[m.length];
        ArrayMax[] threds = new ArrayMax[m.length];
        for(int i = 0; i < m.length; i++){
            threds[i] = new ArrayMax(m[i]);
            threds[i].start();
        }
        for (int i = 0; i < threds.length; i++){
            threds[i].join();
            maximums[i] = threds[i].getMax();
        }
        ArrayMax result = new ArrayMax(maximums);
        result.start();
        result.join();
        System.out.println(result.getMax());
    }

    public static void thirdTask() throws InterruptedException{
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Worker worker1 = new Worker(lock, condition);
        Worker worker2 = new Worker(lock, condition);
        Worker worker3 = new Worker(lock, condition);

        worker1.start();
        worker2.start();
        worker3.start();

        int[] items = {50, 75, 25, 100, 20, 90, 30};

        lock.lock();
        for (int i = 0; i < items.length; i++) {
            while (worker1.weight() + items[i] > 150 || worker2.weight() + items[i] > 150 || worker3.weight() + items[i] > 150) {
                condition.await();
            }

            if(i % 3 == 0)
                worker1.addItem(items[i]);
            else if (i % 3 == 1)
                worker2.addItem(items[i]);
            else
                worker3.addItem(items[i]);
            condition.signalAll();
        }
        lock.unlock();
    }
}