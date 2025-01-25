package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchTerm) {
        super("Не удалось найти подходящую статью для поискового запроса: " + searchTerm);
    }
}
