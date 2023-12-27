public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        if(size < data.length){
            data[size] = element;
            size++;
        } else{
            T[] save = data;
            data = (T[]) new Object[size * 2];
            for(int i  = 0; i < size; i++)
                data[i] = save[i+1];
            data[size] = element;
            size ++;
        }
    }
    public T pop() {
        if(size != 0){;
            T deleted = data[size - 1];
            size--;
            return deleted;
        }
        return null;
    }
    public T peek() {
        if(size!= 0)
            return data[size - 1];
        return null;
    }
}