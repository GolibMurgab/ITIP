public class Order {
    private String data;
    private String goods;
    private boolean status;

    public Order(String data, String goods, boolean status) {
        this.data = data;
        this.goods = goods;
        this.status = status;
    }

    public Order(String data, String goods) {
        this.data = data;
        this.goods = goods;
        this.status = false;
    }

    public String getData(){
        return this.data;
    }
    public String getGoods(){
        return this.goods;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void setData(String data){
        this.data = data;
    }
    public void setGoods(String goods){
        this.goods = goods;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
}
