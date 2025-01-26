package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    final int originalPriceProduct;
    final int discount;

    public DiscountedProduct(String nameProduct, int discount, int originalPriceProduct) {
        super(nameProduct);
        this.discount = discount;
        this.originalPriceProduct = originalPriceProduct;
        if (originalPriceProduct <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть больше нуля.");
        }

        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100.");
        }
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
