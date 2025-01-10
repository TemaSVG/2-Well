package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.core.SearchEngine;
import org.skypro.skyshop.product.*;

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

        Article articleBread = new Article("Булка", "вкусная");
        Article articleChease = new Article("Сырочек", "Очень вкусный");

        SearchEngine searchEngine = new SearchEngine(0);
        searchEngine.add(articleBread);
        searchEngine.add(articleChease);
        searchEngine.add(new FixPriceProduct("Сыр", 100));
        searchEngine.add(new SimpleProduct("Масло", 150));
        searchEngine.add(new DiscountedProduct("Сахар", 10, 100));
        searchEngine.add(new DiscountedProduct("Хлеб", 23, 60));
        for (ISearchable elem : searchEngine.search("О")) {
            if (elem != null) {
                System.out.println(String.format("Тип %s строка %s", elem.getTypeContent(), elem.searchTerm()));
            }
        }
    }
}