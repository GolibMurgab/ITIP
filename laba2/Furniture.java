public abstract class Furniture {
    protected int height;
    protected int length;
    protected int width;
    public Furniture(int length, int width, int height) {
        this.length = length;
        this.height = height;
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setLength(int length){
        this.length = length;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getHeight(){
        return height;
    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }

    public int volume(){
        return length * width * height;
    }

    public abstract void whatIsIt();
}
