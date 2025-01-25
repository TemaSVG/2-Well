package org.skypro.skyshop.product;


import javax.print.DocFlavor;

public abstract class Product implements ISearchable {
    final String nameProduct;

    public Product(String nameProduct) throws NullPointerException {
        this.nameProduct = nameProduct;

        if (nameProduct.isBlank()) {
            throw new NullPointerException("Имя продукта не может быть пустым");
        }
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
