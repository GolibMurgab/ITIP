public class Bed extends Furniture {
    public void whatIsIt() {
        System.out.println("Это кровать");
    }

    private int place;

    public Bed(int length, int width, int height, int place){
        super(length, width, height);
        this.place = place;
    }

    public Bed(){
        this(200, 150, 50, 2);
    }

    public void setPlace(int place){
        this.place = place;
    }

    public int getPlace(){
        return place;
    }

    @Override
    public int volume(){
        return length * width;
    }
}
