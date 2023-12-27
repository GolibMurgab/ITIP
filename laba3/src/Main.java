import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] Args) {
        Hashtable<String, Order> orders = new Hashtable<>();
        orders.put("q1234", new Order("2002/12/21", "apples, bananas, pineapples", false));
        orders.put("a1454", new Order("2003/01/2", "bmw, mercedes", false));
        orders.put("b3543", new Order("2002/12/25", "xiaomi, apple, samsung", true));
        orders.put("m0095", new Order("2002/12/30", "Rayan Gosling, Bob Odenkirck", false));

        System.out.print("Пустой ли массив: ");
        System.out.println(orders.isEmpty());
        System.out.print("Сколько заказов: ");
        System.out.println(orders.size());
        orders.remove("b3543");
        System.out.println(orders.get("b3543"));
        orders.remove("123");
        System.out.print("Число заказов после удаления одного: ");
        System.out.println(orders.size());
        orders.get("m0095").setStatus(true);
        System.out.print("Статус заказа m0095: ");
        System.out.println(orders.get("m0095").getStatus());

        List list = new ArrayList<>();



    }
}