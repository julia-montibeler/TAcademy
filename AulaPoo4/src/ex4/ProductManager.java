package ex4;

import java.util.ArrayList;

public class ProductManager {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Product p) {
        products.add(p);
    }

    public static void removeProduct(Product p) {
        products.remove(p);
    }

    public static void print() {
        for (Product p : products) {
            System.out.println(p.getName() + ": R$" +p.getPrice());
        }
    }
}
