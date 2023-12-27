import java.io.*;

public class CopyFromFile {
    public static void main(String[] args){
        try{
            FileReader fileReader = new FileReader("D:\\Мтуси\\3 семестр\\итп\\laba4\\1.txt");
            FileWriter fileWriter = new FileWriter("D:\\Мтуси\\3 семестр\\итп\\laba4\\2.txt");
            BufferedReader in = new BufferedReader(fileReader);
            BufferedWriter out = new BufferedWriter(fileWriter);

            out.write(in.readLine());

            in.close();
            fileReader.close();

            fileWriter.close();
            out.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
