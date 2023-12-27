import java.util.List;
@DataProcessor
public class Filter {
    int length;
    Filter(int length){
        this.length = length;
    }
    @DataProcessor
    public List<String> filter(List<String> data) {
        return data.stream()
                .filter(str -> str.length() > length)
                .toList();
    }
}
