package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        ProductBasket Basket = new ProductBasket(products);
        Basket.addProductBasket(new FixPriceProduct("Сыр", 100));
        Basket.addProductBasket(new SimpleProduct("Масло", 150));
        Basket.addProductBasket(new DiscountedProduct("Сахар", 10, 100));
        Basket.addProductBasket(new DiscountedProduct("Хлеб", 23, 60));
        Basket.totalСostBasket();
        Basket.printСontentsBasket();
        System.out.println(Basket.searchProductByName("Сыр"));
        Basket.clearBasket();
    }
}