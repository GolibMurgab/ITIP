public class Main {
    public static void main(String[] args){
        DataManager dataManager = new DataManager("2.txt");
        dataManager.loadData("1.txt");

        dataManager.registerDataProcessor(new Agregator());
        dataManager.registerDataProcessor(new Transformer("all"));
        dataManager.registerDataProcessor(new Filter(2));

        dataManager.processData();
    }
}