import java.util.List;
import java.util.stream.Collectors;
@DataProcessor
public class Transformer {
    String word;
    Transformer(String word){
        this.word = word;

    }
    @DataProcessor
    public List<String> transform(List<String> data) {
        return  data.stream()
                .map(str -> str.replaceAll(word, "OBAMA"))
                .toList();
    }
}
