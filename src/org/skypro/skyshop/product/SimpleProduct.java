package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    final int priceProduct;

    public SimpleProduct(String nameProduct, int productPrice) throws IllegalArgumentException {
        super(nameProduct);
        this.priceProduct = productPrice;
        if (productPrice <= 0){
            throw new IllegalArgumentException("Цена товара не может быть 0 или меньше");
        }
    }

    @Override
    public double getPriceProduct() {
        return priceProduct;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", nameProduct, getPriceProduct());
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
