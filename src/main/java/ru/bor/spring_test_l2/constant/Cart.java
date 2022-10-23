package ru.bor.spring_test_l2.constant;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Scope("prototype")
public class Cart {

    private final Map<Product, Integer> cartMap = new ConcurrentHashMap<>();
    //---------------------
    public void addProduct(Product product, Integer quantity){
        if (product != null){
            cartMap.put(product, quantity);
        }
    }
    public void delProduct(String name){

        //удобный метод перебора карты
        cartMap.forEach((k, v) -> {
            if(k.getName().equals(name)){
                cartMap.remove(k);
            }
        });
    }
    //Цена в int, так как дз не о форматах...
    //метод не пригодился...
    public int getOneProductSumByName(String name){
        //Entry - интерфейс для взятия карты
        for (Map.Entry<Product, Integer> cartMap : cartMap.entrySet()) {
            if(cartMap.getKey().getName().equals(name)){
                return (cartMap.getKey().getPrice()) * cartMap.getValue();
            }else{
                System.out.println("Нет продукта с таким названием");
            }
        }
        return 0;
    }
    public int getAllProductSum(){
        int sum = 0;
        for (Map.Entry<Product, Integer> cartMap : cartMap.entrySet()) {
            sum+=(cartMap.getKey().getPrice())*cartMap.getValue();
        }
        return sum;
    }

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }
    public void clearCartMap(){
        cartMap.clear();
    }
}
