package ru.bor.spring_test_l2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.bor.spring_test_l2.constant.Cart;
import ru.bor.spring_test_l2.constant.Product;
import ru.bor.spring_test_l2.constant.ProductRepository;
import java.util.Map;
import java.util.Scanner;

@Component
@Scope("prototype")
//можно было бы и на каждого пользователя по несколько корзин делать, -> не целесообразно...
public class ConsoleMarket {
    @Autowired
    ProductRepository productRepositoryExample;
    @Autowired
    Cart cartExample;
    Scanner scanner = new Scanner(System.in);

    private void printInitPage() {
        System.out.println("Приветствуем вас в нашем магазине: " + "От Батона до ЛуиВитона!");
        System.out.println("Наша продукция:");
        productRepositoryExample.printAllProductList();
        System.out.println("------------------------------------------------------------------- ");
        System.out.println("Команды:");

        System.out.println("add" + "                  - добавить товар");
        System.out.println("delete" + "                - удалить товар");
        System.out.println("cart" + "               - показать корзину");
        System.out.println("clear" + "              - очистить корзину");
        System.out.println("buy" + "                          - купить");
        System.out.println("exit" + "                          - выход");
    }

    public void start() {
        printInitPage();
        System.out.println("Введите команду...");
        while (true) {
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("add")) {
                addProduct();
            }
            if (cmd.equals("delete")) {
                deleteProduct();
            }
            if (cmd.equals("cart")) {
                cartView();
            }
            if (cmd.equals("clear")) {
                cartClear();
            }
            if (cmd.equals("buy")) {
                buy();
            }
            if (cmd.equals("exit")) {
                break;
            }

        }

        scanner.close();
        System.out.println("Спасибо за покупку!\nУ Каджита есть товар, если у тебя есть монеты, друг ;)...");
        System.exit(0);
    }

    private void buy() {
        System.out.println("Вы совершили покупку!!!!");
        cartExample.clearCartMap();
        System.out.println("OK");
        System.out.println("Введите команду...");
    }

    private void cartClear() {
        cartExample.clearCartMap();
        System.out.println("Ваша козина пуста!");
        System.out.println("OK");
        System.out.println("Введите команду...");
    }

    private void deleteProduct() {
        System.out.println("Введите название продукта для удаления из корзины...");
        String strDell = scanner.nextLine().trim();
        cartExample.delProduct(strDell);
        System.out.println("Продукт "+strDell+" удален!");
        System.out.println("OK");
        System.out.println("Введите команду...");
    }

    private void cartView() {
        Map<Product, Integer> example = cartExample.getCartMap();
        System.out.println("Ваша корзина:");
        example.forEach((k, v) -> {
            System.out.println(k.toString());
            System.out.println("Количество: " + v);
        });
        System.out.println("-----------");
        System.out.println("Итого: " + cartExample.getAllProductSum());

        System.out.println("OK");
        System.out.println("Введите команду...");
    }

    private void addProduct() {
        int[] order = new int[2];
        System.out.println("Введите id продукта для добавления в корзину...");
        order[0] = scanner.nextInt();
        //тут надо проверку на id
        System.out.println("Введите количество");
        order[1] = scanner.nextInt();
        cartExample.addProduct(productRepositoryExample.getProductById(order[0]),order[1] );
        System.out.println("OK");
        System.out.println("Введите команду...");
    }


}



