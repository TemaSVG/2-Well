package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    final List<Product> productBasket;


    public ProductBasket() {
        productBasket = new LinkedList<>();
    }

    public int countSpecialProducts() {
        int countSpecialProduct = 0;
        for (Product product : productBasket) {
            if ((product != null) && (product.isSpecial())) {
                countSpecialProduct++;
            }
        }
        return countSpecialProduct;
    }

    public void addProductBasket(Product newProduct) {
        productBasket.add(newProduct);
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new LinkedList<>();

        productBasket.removeIf(product -> {
            if (product.getNameProduct().equals(name)) {
                removedProducts.add(product);
                return true;
            }
            return false;
        });
        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных товаров пуст");
        }
        return removedProducts;
    }

    public double totalСostBasket() {
        double result = 0;
        for (Product product : productBasket) {
            result += product.getPriceProduct();
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
            for (Product product : productBasket) {
                System.out.println(String.format("Название: %s, Цена: %.2f", product.getNameProduct(), product.getPriceProduct()));
            }
            System.out.println(String.format("Итого: %s", totalСostBasket()));
            System.out.println(String.format("Специальных товаров: %s", countSpecialProducts()));
        }
    }

    public boolean searchProductByName(String nameProduct) {
        boolean buff = false;
        for (Product product : productBasket) {
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
