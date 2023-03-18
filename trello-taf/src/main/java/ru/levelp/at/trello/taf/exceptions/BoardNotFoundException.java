package ru.levelp.at.trello.taf.exceptions;

public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(String boardName) {
        super(String.format("Доска '%s' не найдена", boardName));
    }
}
