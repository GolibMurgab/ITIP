public class Nephie extends Table{
    @Override
    public void whatIsIt() {
        System.out.println("Это простынь");
    }

    public Nephie(int length, int width, int height, String material){
        super(length, width, height, material);
    }

    public Nephie(){
        super();
    }
}
