import java.util.ArrayList;
import java.util.List;
@DataProcessor
public class Agregator {
    @DataProcessor
    public List<String> aggregate(List<String> data) {
        String word = data.stream().reduce("", (str1, str2) -> str1 + str2);
        List<String> list = new ArrayList<>();
        list.add(word);
        return list;
    }
}
