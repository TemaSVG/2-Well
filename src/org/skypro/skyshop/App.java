package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.core.SearchEngine;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        System.out.println("Демонстрация работы корзины");
        ProductBasket Basket = new ProductBasket();
        Basket.addProductBasket(new FixPriceProduct("Сыр", 100));
        Basket.addProductBasket(new SimpleProduct("Масло", 150));
        Basket.addProductBasket(new DiscountedProduct("Сахар", 10, 100));
        Basket.addProductBasket(new DiscountedProduct("Хлеб", 23, 60));
        Basket.printСontentsBasket();
        System.out.println(Basket.searchProductByName("Сыр"));
        System.out.println();

        System.out.println("Демонстрация поиска");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(new FixPriceProduct("Сыр", 100));
        searchEngine.add(new SimpleProduct("Масло", 150));
        searchEngine.add(new DiscountedProduct("Сахар", 10, 100));
        searchEngine.add(new DiscountedProduct("Хлеб", 23, 60));
        searchEngine.add(new FixPriceProduct("Апельсины", 120));
        searchEngine.add(new Article("Сырочек", "Очень вкусный"));
        searchEngine.add(new Article("Булка", "вкусная"));
        System.out.println(searchEngine.search("ы"));
        System.out.println();

        System.out.println("Демонстрация исключений");
        try {
            new SimpleProduct("Product", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка окончена.");
        }
        System.out.println(searchEngine.findTheMostSuitable("е"));

        try {
            searchEngine.findTheMostSuitable("1");
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("Демонстрация удаления товара из корзины по имени");
        System.out.println(Basket.removeProductByName("Сыр"));
        Basket.printСontentsBasket();
        Basket.removeProductByName("яйцо");
        System.out.println();

        System.out.println("Демонстрация сортировки");
        for (ISearchable result : searchEngine.getSortedResult()) {
            System.out.println(result);
        }

    }
}