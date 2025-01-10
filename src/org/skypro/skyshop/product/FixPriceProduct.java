package org.skypro.skyshop.product;


public class FixPriceProduct extends Product {
    final int FIX_PRICE_PRODUCT;

    public FixPriceProduct(String nameProduct, int FIX_PRICE_PRODUCT) {
        super(nameProduct);
        this.FIX_PRICE_PRODUCT = FIX_PRICE_PRODUCT;
    }


    @Override
    public double getPriceProduct() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return String.format("%s: Фиксированная цена %s", nameProduct, getPriceProduct());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
