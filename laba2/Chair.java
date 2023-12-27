public class Chair extends Furniture {
    public void whatIsIt(){
        System.out.println("Это стул");
    }
    private static int numberOfChairs = 0;
    private int numberOfLegs;

    public Chair(int length, int width, int height, int numberOfLegs){
        super(length, width, height);
        this.numberOfLegs = numberOfLegs;
        numberOfChairs += 1;
    }

    public Chair(){
        this(10, 10, 10, 4);
    }

    public int howManyChairs(){
        return numberOfChairs;
    }

    public int getNumberOfLegs(){
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs){
        this.numberOfLegs = numberOfLegs;
    }

}
