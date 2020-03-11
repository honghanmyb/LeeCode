import java.util.HashMap;
import java.util.Map;

class Cashier {
    private Map<Integer, Integer> idToIndex;
    private int billCount;
    private int discount;
    private int n;
    private int[] prices;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.billCount = 0;
        this.idToIndex = new HashMap<>();
        this.prices = prices;
        for(int i = 0; i < products.length; i++){
            idToIndex.put(products[i], i);
        }
    }

    public double getBill(int[] product, int[] amount) {
        int price = 0;
        ++billCount;
        for(int i = 0; i < product.length; i++){
            int index = idToIndex.get(product[i]);
            price += (prices[index] * amount[i]);
        }
        if(billCount == n){
            billCount = 0;
            return 1.0 * price - (1.0 * discount * price) / 100;
        }else{
            return 1.0 * price;
        }
    }
}