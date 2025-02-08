package org.skypro.skyshop.product;

import java.util.Objects;

public class Article implements ISearchable {
    String articleTitle;
    String articleContent;

    public Article(String articleTitle, String articleContent) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Article article = (Article) obj;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle, articleContent);
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
