package ru.bor.spring_test_l2.constant;

public class Product {
    private Product productInstance;
    private int id;
    private static int idCounter = 1;
    private String name;

    //цена в int, так как дз не о форматах...
    private int price;
    public Product(String name, int price) {
    this.id = idCounter++;
    this.price = price;
    this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}