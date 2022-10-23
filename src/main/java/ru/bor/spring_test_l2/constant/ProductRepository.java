package ru.bor.spring_test_l2.constant;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class ProductRepository {
    private List<Product> someProducts = new ArrayList<>();

    @PostConstruct
    public void addSomeProducts(){
        someProducts.add(new Product("Чай-май",10));
        someProducts.add(new Product("Кофе-мофе",100));
        someProducts.add(new Product("Мыло-шмыло",100));
        someProducts.add(new Product("Сигареты-мигареты",100));
        someProducts.add(new Product("Мясо-шмясо",1000));
        someProducts.add(new Product("Паштет-маштет",50));
        someProducts.add(new Product("Колбос-молбос",300));
        someProducts.add(new Product("Хлеб-меб",50));
        someProducts.add(new Product("Обувь-шмобувь",2000));
        someProducts.add(new Product("Куртка-шмуртка",10000));
        someProducts.add(new Product("Шапка-шмапка",1000));
    }

    public List<Product> getSomeProductsArrayList() {
        return someProducts;
    }
    public void printAllProductList(){
        someProducts.forEach((product) -> {
            System.out.println(product.toString());
        });
    }
    public Product getProductById(int id) {
        for (int i = 0; i < someProducts.size(); i++) {
            if (someProducts.get(i).getId() == id) {
                return someProducts.get(i);
            } else {
                System.out.println("Нет товара с заданным id");
            }
        }
        return null;
    }









}
