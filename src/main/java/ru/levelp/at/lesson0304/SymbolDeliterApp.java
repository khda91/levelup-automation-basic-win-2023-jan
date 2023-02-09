package ru.levelp.at.lesson0304;

import org.apache.commons.collections4.CollectionUtils;
import java.util.List;
import java.util.stream.Collectors;

public class SymbolDeliterApp implements SymbolDeliter {

    @Override
    public List<String> deleteSymbol(List<String> list, String letter) {
        if (CollectionUtils.isEmpty(list)) {
            throw new IllegalArgumentException("Входные данные не могут быть пустыми");
        }

        if (letter == null) {
            throw new IllegalArgumentException("Не задан удаляемый символ");
        }

        if (letter.length() > 1) {
            throw new IllegalArgumentException("Длина удаяемого символа не может быть больше 1");
        }

        return list.stream()
            .map(str -> str.replaceAll(letter, ""))
            .collect(Collectors.toList());
    }
}
