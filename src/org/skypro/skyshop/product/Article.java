package org.skypro.skyshop.product;

public class Article implements ISearchable {
    String articleTitle;
    String articleContent;

    public Article(String articleTitle, String articleContent) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return "";
    }

    @Override
    public String toString() {
        return articleTitle + " " + articleContent;
    }
}
