public class Main {
    public static void main(String[] Args){
        Chair chair1 = new Chair();
        Chair chair2 = new Chair(100, 100, 100, 4);
        Table table1 = new Table();
        Bed bed1 = new Bed(100, 100, 100, 3);
        Nephie nephie1 = new Nephie();

        table1.setLength(123);
        nephie1.whatIsIt();


        System.out.println("Число объектов стул = " + chair1.howManyChairs());
        System.out.println("Длина стола = " + table1.getLength());
        System.out.println("Площадь кровати = " + bed1.volume());
    }
}
