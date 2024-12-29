package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private Product[] productBasket;


    public ProductBasket(Product[] productBasket) {
        this.productBasket = productBasket;
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
        int i = 0;
        for (Product product : productBasket) {
            if (product == null) {
                productBasket[i] = newProduct;
                break;
            } else {
                i++;
            }
        }
    }

    public double totalСostBasket() {
        double result = 0;
        for (Product product : productBasket) {
            if (product == null) {
                break;
            } else {
                result += product.getPriceProduct();
            }
        }
        return result;
    }

    public void printСontentsBasket() {
        countSpecialProducts();
        if (productBasket[0] != null) {
            for (Product product : productBasket) {
                if (product != null) {
                    System.out.println(product);
                }
            }
            System.out.println(String.format("Итого: %s", totalСostBasket()));
            System.out.println("Специальных товаров: " + countSpecialProducts());
        } else {
            System.out.println("в корзине пусто");
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
        int i = 0;
        for (Product product : productBasket) {
            productBasket[i] = null;
            i++;
        }
    }

    @Override
    public String toString() {
        return null;
    }

}
