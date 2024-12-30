package org.skypro.skyshop.product;

import org.skypro.skyshop.basket.ProductBasket;

public class DiscountedProduct extends Product {
    int originalPriceProduct;
    int discount;

    public DiscountedProduct(String nameProduct, int discount, int originalPriceProduct) {
        super(nameProduct);
        this.discount = discount;
        this.originalPriceProduct = originalPriceProduct;
    }

    @Override
    public double getPriceProduct() {
        return originalPriceProduct - ((double) originalPriceProduct / 100 * discount);
    }

    @Override
    public String toString() {
        return String.format("%s: %.1f скидка %s%%", nameProduct, getPriceProduct(), discount);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
