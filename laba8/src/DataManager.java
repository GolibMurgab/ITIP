import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataManager {
    DataManager(String filePath){
        this.filePath = filePath;
        data = new ArrayList<>();
        processors = new ArrayList<>();
    }
    private List<Object> processors;
    private List<String> data;
    private String filePath;

    public void registerDataProcessor(Object processor) {
        if(processor.getClass().isAnnotationPresent(DataProcessor.class))
            processors.add(processor);
    }

    public void loadData(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            data = List.of(line.split(" "));
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void processData() {
        ExecutorService executorService = Executors.newFixedThreadPool(processors.size());
        for (Object processor : processors) {
            executorService.submit(() -> processor(processor));
        }
        executorService.shutdown();
    }

    private synchronized void processor(Object processor) {
        if (data == null) {
            throw new IllegalStateException("Data not loaded");
        } else {
            Method[] methods = processor.getClass().getDeclaredMethods();
            List<Method> annotatedMethods = Arrays.stream(methods)
                    .filter(m -> m.getAnnotation(DataProcessor.class) != null)
                    .toList();
            for (Method method: annotatedMethods) {
                try {
                    data = (List<String>) method.invoke(processor, data);
                    saveData();
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace ();
                }
            }
        }
    }

    public synchronized void saveData() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(data.toString().
                    replaceAll("\\[", "").
                    replaceAll("]",""));
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
