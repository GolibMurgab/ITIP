import java.util.*;
public class Sale{
    private HashSet<String> soldItems;
    private HashMap<String, Map.Entry<Integer, Double>> itemsInfo;

    public Sale() {
        soldItems = new HashSet<>();
        itemsInfo = new HashMap<>();
    }

    public void addSale(String item, Integer howMany) {
        soldItems.add(item);
        if (itemsInfo.containsKey(item)) {
            Integer n = itemsInfo.get(item).getKey() + howMany;
            Double price = itemsInfo.get(item).getValue();
            itemsInfo.put(item, new AbstractMap.SimpleEntry<Integer, Double>(n, price));
        } else {
            System.out.println("Такого товара нет");
        }
    }

    public void addSale(String item, Double price, Integer howMany) {
        soldItems.add(item);
        itemsInfo.put(item, new AbstractMap.SimpleEntry<Integer, Double>(howMany, price));
    }

    public void printSale() {
        Iterator<String> iterator = soldItems.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " " + itemsInfo.get(key).getKey());
        }
    }

    public String mostPopular() {
        String mostPopular = "";
        Integer maxSales = 0;
        Iterator<String> iterator = soldItems.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if(itemsInfo.get(key).getKey() > maxSales){
                mostPopular = key;
                maxSales = itemsInfo.get(key).getKey();
            }
        }
        return mostPopular;
    }
    public double totalSale() {
        double totalSale = 0.;
        Iterator<String> iterator = soldItems.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            totalSale += itemsInfo.get(key).getKey() *
                    itemsInfo.get(key).getValue();
        }
        return totalSale;
    }

    public static void main(String[] args) {
        Sale magazine = new Sale();

        magazine.addSale("Apple", 2.5, 9);
        magazine.addSale("Orange", 1.8, 10);
        magazine.addSale("Apple", 1);
        magazine.addSale("Banana", 1.4, 100);

        magazine.printSale();

        System.out.println("Самый популярный товар: " + magazine.mostPopular());
        System.out.println("Общая сумма покупок: " + magazine.totalSale());
    }
}
