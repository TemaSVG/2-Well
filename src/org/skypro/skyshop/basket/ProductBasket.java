package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    final HashMap<String, List<Product>> productBasket;


    public ProductBasket() {
        productBasket = new HashMap<>();
    }

    public int countSpecialProducts() {
        int countSpecialProduct = 0;
        for (List<Product> products : productBasket.values()) {
            for (Product product : products) {
                if ((product != null) && (product.isSpecial())) {
                    countSpecialProduct++;
                }
            }
        }
        return countSpecialProduct;
    }

    public void addProductBasket(Product newProduct) {
        productBasket.computeIfAbsent(newProduct.getNameProduct(), k -> new ArrayList<>()).add(newProduct);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new LinkedList<>();

        Iterator<Map.Entry<String, List<Product>>> iterator = productBasket.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<Product>> entry = iterator.next();
            List<Product> products = entry.getValue();

            Iterator<Product> productIterator = products.iterator();
            while (productIterator.hasNext()) {
                Product product = productIterator.next();
                if (product.getNameProduct().equals(name)) {
                    removedProducts.add(product);
                    productIterator.remove();
                }
            }
            if (products.isEmpty()) {
                iterator.remove();
            }
        }

        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных товаров пуст");
        }
        return removedProducts;
    }

    public double totalСostBasket() {
        double result = 0;
        for (List<Product> products : productBasket.values()) {
            for (Product product : products) {
                result += product.getPriceProduct();
            }
        }
        return result;
    }

    public void printСontentsBasket() {
        countSpecialProducts();
        totalСostBasket();
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Продукты в корзине:");
            for (List<Product> products : productBasket.values())
                for (Product product : products) {
                    System.out.println(String.format("Название: %s, Цена: %.2f", product.getNameProduct(), product.getPriceProduct()));
                }
            System.out.println(String.format("Итого: %s", totalСostBasket()));
            System.out.println(String.format("Специальных товаров: %s", countSpecialProducts()));
        }
    }

    public boolean searchProductByName(String nameProduct) {
        boolean buff = false;
        for (List<Product> products : productBasket.values())
        for (Product product : products) {
            if (product != null && nameProduct.equals(product.getNameProduct())) {
                buff = true;
            }
        }
        return buff;
    }

    public void clearBasket() {
        productBasket.clear();
    }
}
