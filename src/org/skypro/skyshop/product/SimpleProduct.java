package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int priceProduct;

    public SimpleProduct(String nameProduct, int productPrice) {
        super(nameProduct);
        this.priceProduct = productPrice;
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
