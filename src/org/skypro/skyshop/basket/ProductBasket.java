package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;


public class ProductBasket {
    final HashMap<String, List<Product>> productBasket;


    public ProductBasket() {
        productBasket = new HashMap<>();
    }

    public long countSpecialProducts() {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void addProductBasket(Product newProduct) {
        productBasket.computeIfAbsent(newProduct.getNameProduct(), k -> new ArrayList<>()).add(newProduct);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(product -> product.getNameProduct().equals(name))
                .collect(Collectors.toList());

        productBasket.entrySet().removeIf(entry -> {
            entry.getValue().removeIf(product -> product.getNameProduct().equals(name));
            return entry.getValue().isEmpty();
        });

        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных товаров пуст");
        }
        return removedProducts;
    }

    public double totalСostBasket() {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getPriceProduct)
                .sum();
    }

    public void printСontentsBasket() {
        countSpecialProducts();
        totalСostBasket();
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Продукты в корзине:");
            productBasket.values().stream()
                            .flatMap(Collection::stream)
                            .forEach(product -> System.out.println(String.format("Название: %s, Цена: %.2f", product.getNameProduct(), product.getPriceProduct())));
            System.out.println(String.format("Итого: %s", totalСostBasket()));
            System.out.println(String.format("Специальных товаров: %s", countSpecialProducts()));
        }
    }

    public boolean searchProductByName(String nameProduct) {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product -> product.getNameProduct().equals(nameProduct));
    }

    public void clearBasket() {
        productBasket.clear();
    }
}
