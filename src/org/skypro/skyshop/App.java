package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.core.SearchEngine;
import org.skypro.skyshop.core.SearchHistory;
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

        Article articleBread = new Article("Булка", "вкусная");
        Article articleChease = new Article("Сырочек", "Очень вкусный");
        System.out.println();

        System.out.println("Демонстрация поиска");
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(articleBread);
        searchEngine.add(articleChease);
        searchEngine.add(new FixPriceProduct("Сыр", 100));
        searchEngine.add(new SimpleProduct("Масло", 150));
        searchEngine.add(new DiscountedProduct("Сахар", 10, 100));
        searchEngine.add(new DiscountedProduct("Хлеб", 23, 60));
        searchEngine.add(new FixPriceProduct("Апельсины", 120));
        System.out.println(searchEngine.search("а"));
        System.out.println();

        System.out.println("Демонстрация исключений");
        try {
            new SimpleProduct("Product", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка окончена.");
        }
//        System.out.println(searchEngine.findTheMostSuitable("а"));
//
//        try {
//            searchEngine.findTheMostSuitable("1");
//        } catch (BestResultNotFound e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println();

        System.out.println("Демонстрация удаления товара из корзины по имени");
        System.out.println(Basket.removeProductByName("Сыр"));
        Basket.printСontentsBasket();
        Basket.removeProductByName("яйцо");

        System.out.println("TEST");
        searchEngine.add(new Article("Морковка", "Корнеплод"));
        searchEngine.add(new Article("Яблоко", "Фрукт"));
        searchEngine.add(new Article("Картофель", "Клубень"));
        searchEngine.add(new Article("Груша", "Фрукт"));
        searchEngine.add(new Article("Лук", "Приправы"));
        searchEngine.add(new Article("Банан", "Тропический фрукт"));
        searchEngine.add(new Article("Тыква", "Бахчевые"));
        searchEngine.add(new Article("Апельсин", "Цитрус"));
        searchEngine.add(new Article("Капуста", "Листовой овощ"));
        searchEngine.add(new Article("Малина", "Ягода"));
        searchEngine.add(new Article("Клубника", "Ягода"));
        searchEngine.add(new Article("Огурец", "Бахчевые"));
        searchEngine.add(new Article("Персик", "Косточковый фрукт"));
        searchEngine.add(new Article("Киви", "Экзотический фрукт"));
        searchEngine.add(new Article("Черника", "Лесная ягода"));
        searchEngine.add(new Article("Слива", "Косточковый фрукт"));
        searchEngine.add(new Article("Гранат", "Экзотический фрукт"));
        searchEngine.add(new Article("Чеснок", "Приправы"));
        searchEngine.add(new Article("Свекла", "Корнеплод"));
        searchEngine.add(new Article("Редис", "Корнеплод"));
        searchEngine.add(new Article("Лимон", "Цитрус"));
        searchEngine.add(new Article("Авокадо", "Суперфуд"));
        searchEngine.add(new Article("Шпинат", "Листовая зелень"));
        searchEngine.add(new Article("Брокколи", "Крестоцветные"));
        searchEngine.add(new Article("Голубика", "Лесная ягода"));
        searchEngine.add(new Article("Ежевика", "Лесная ягода"));
        searchEngine.add(new Article("Финик", "Сухофрукт"));
        searchEngine.add(new Article("Вишня", "Косточковый фрукт"));
        searchEngine.add(new Article("Помидор", "Пасленовые"));
        searchEngine.add(new Article("Арбуз", "Бахчевые"));
        searchEngine.add(new Article("Дыня", "Бахчевые"));
        searchEngine.add(new Article("Грейпфрут", "Цитрус"));
        searchEngine.add(new Article("Мандарин", "Цитрус"));
        searchEngine.add(new Article("Черешня", "Косточковый фрукт"));
        searchEngine.add(new Article("Фасоль", "Бобовые"));
        searchEngine.add(new Article("Горох", "Бобовые"));
        searchEngine.add(new Article("Кабачок", "Тыквенные"));
        searchEngine.add(new Article("Баклажан", "Пасленовые"));
        searchEngine.add(new Article("Клюква", "Болотная ягода"));
        searchEngine.add(new Article("Рябина", "Лесная ягода"));
        searchEngine.add(new Article("Манго", "Тропический фрукт"));
        searchEngine.add(new Article("Папайя", "Экзотический фрукт"));
        searchEngine.add(new Article("Малина", "Лесная ягода"));
        searchEngine.add(new Article("Фейхоа", "Экзотический фрукт"));
        searchEngine.add(new Article("Смородина", "Садовая ягода"));
        searchEngine.add(new Article("Облепиха", "Лекарственное растение"));
        searchEngine.add(new Article("Ананас", "Тропический фрукт"));
        searchEngine.add(new Article("Лайм", "Цитрус"));
        searchEngine.add(new Article("Инжир", "я пошел по гулять"));

        for (ISearchable searchable : searchEngine.getMaxMidMinIndex("о")) {
            System.out.println(searchable);
        }

        searchEngine.printSearchHistory();
        System.out.println(searchEngine.search("Лек"));

    }

}