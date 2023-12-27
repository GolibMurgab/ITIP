import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Worker extends Thread{
    static List<Integer> item;
    private Lock lock;
    private Condition condition;
    public Worker(Lock lock, Condition condition) {
        item = new ArrayList<>();
        this.lock = lock;
        this.condition = condition;
    }
    @Override
    public void run() {
        lock.lock();
        while (item.isEmpty()) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Грузчики разгружают" + item.toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        item.clear();
        condition.signalAll();
        lock.unlock();
    }
    public void addItem(int weight) {
        item.add(weight);
    }

    public int weight() {
        int sum = 0;
        for (int i : item) {
            sum += i;
        }
        return sum;
    }
}
