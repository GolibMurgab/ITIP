public class Table extends Furniture{

    public void whatIsIt() {
        System.out.println("Это стол");
    }

    private String material;

    public Table(int length, int width, int height, String material){
        super(length, width, height);
        this.material = material;
    }

    public Table(){
        this(100, 100, 70, "Кедр");
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial(){
        return material;
    }
}
