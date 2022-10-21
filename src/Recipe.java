import java.util.*;

public class Recipe {
    private final String nameRecipe;
    private final Map<Product, Integer> productMap;
    private float priceSummary;

    public Recipe(String nameRecipe, Map<Product,Integer> productMap) {
        this.nameRecipe = nameRecipe;
        if(productMap==null) {
            this.productMap = new HashMap<>();
        }else{
            //проверка на количество продукта > 0
            for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
                if(entry.getValue()<=0){
                    entry.setValue(1);
                }
            }
            this.productMap = productMap;
        }
        calculateSummary();
    }

    private void calculateSummary(){
        priceSummary=0f;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
           Product product = entry.getKey();//продукт
           float price = product.getPrice(); //стоимость единицы продукта
           int count = entry.getValue(); //количество продуктов
           priceSummary = priceSummary + count * price;
        }
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
    }

    public float getPriceSummary() {
        return priceSummary;
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
        Recipe anyRecipe = (Recipe) obj;
        return this.nameRecipe.equals(anyRecipe.nameRecipe);
    }

    @Override
    public int hashCode() {
        return nameRecipe.hashCode();
    }

    @Override
    public String toString() {
        String s = "";
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            Product product = entry.getKey();//продукт
            int count = entry.getValue(); //количество продуктов
            s= s + product+", количество "+count+"\n";
        }
        s = s + "суммарная стоимость "+ priceSummary + " руб.\n";
        return "\n"+nameRecipe+"\n" + s;
    }

}
