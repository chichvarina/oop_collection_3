import java.util.Objects;

public class Product {

    private final String name;
    private float price;
    private float volume;

    public Product(String name, float price, float volume) throws Exception {
        if(name!=null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        }else{
            throw new Exception("Заполните карточку товара полностью");
        }
        setPrice(price);
        setVolume(volume);
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) throws Exception {
        if(price>0f) {
            this.price = price;
        }else{
            throw new Exception("Заполните карточку товара полностью");
        }
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) throws Exception {
        if (volume>0f){
            this.volume = volume;
        }else {
            throw new Exception("Заполните карточку товара полностью");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,price,volume);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }else if(obj==null){
            return false;
        }else if(this.getClass()!=obj.getClass()){
            return false;
        }
        Product anyProduct = (Product) obj;
        return this.name.equals(anyProduct.name) && this.price==anyProduct.price && this.volume==anyProduct.volume;
    }

    @Override
    public String toString() {
        return name+" "+price+" руб. "+volume+" кг";
    }
}
