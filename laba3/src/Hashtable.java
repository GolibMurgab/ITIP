import java.util.Arrays;
import java.util.LinkedList;

import static java.util.Objects.hash;

public class Hashtable<K, V> {
    private int size = 0;
    class Entry{
        private K key;
        private V value;
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
    LinkedList<Entry>[] table;


    public Hashtable(){
        table = new LinkedList[10];
        Arrays.fill(table, null);
    }

    public void put(K key, V value) {
        int index = hash(key) % 10;
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry(key, value));
        this.size++;
    }

    public V get(K key){
        int index = hash(key) % 10;
        LinkedList<Entry> list = table[index];
        int i = 0;
        while(list != null && i < list.size()){
            if(list.get(i).getKey().equals(key))
                return list.get(i).value;
            i++;
        }
        return null;
    }

    public void remove(K key){
        if(get(key) != null){
            int index = hash(key) % 10;
            LinkedList<Entry> list = table[index];
            int i = 0;
            while(i < list.size() && list.get(i) != null){
                if(list.get(i).getKey().equals(key))
                    list.remove(i);
                i++;
            }
            this.size--;
        }
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }
}