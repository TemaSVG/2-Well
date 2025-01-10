package org.skypro.skyshop.product;


public abstract class Product implements ISearchable {
    final String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String searchTerm() {
        return nameProduct;
    }

    @Override
    public String getStringRepresentation() {
        return "";
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract double getPriceProduct();

    public abstract boolean isSpecial();

}
