package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        ProductBasket Basket = new ProductBasket(products);
        Basket.addProductBasket(new Product("Сыр", 100));
        Basket.addProductBasket(new Product("Масло", 150));
        Basket.totalСostBasket();
        Basket.printСontentsBasket();
        System.out.println(Basket.searchProductByName("Сыр"));
        Basket.clearBasket();
    }
}