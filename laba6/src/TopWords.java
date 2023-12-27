import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class TopWords {
    public static void main(String[] args) {
        String filePath = "D:\\Мтуси\\3 семестр\\итп\\laba6\\text.txt";
        File file = new File(filePath);
        Map<String, Integer> words = new HashMap<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext("\\b\\w+\\b")) {
                String newWord = scanner.findInLine("\\b\\w+\\b").toLowerCase();
                if (words.containsKey(newWord)) {
                    words.put(newWord, words.get(newWord) + 1);
                } else {
                    words.put(newWord, 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String,
                        Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i).getKey() + " " + list.get(i).getValue());
        }
    }
}
