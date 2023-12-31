package com.gourianovd.texthandler.chainparser;


import com.gourianovd.texthandler.entity.Symbol;
import com.gourianovd.texthandler.entity.TextComposite;

import java.util.Arrays;
import java.util.List;

public class LexemeParser implements ChainParser {
    private final String LEXEME_TO_SYMBOL = "";

    @Override
    public TextComposite parse(String lexemeString, TextComposite lexemeComposite) {
        List<String> symbolList = Arrays.asList(lexemeString.split(LEXEME_TO_SYMBOL));
        symbolList.forEach((symbolString) -> {
            Symbol symbolComponent = new Symbol(symbolString);
            lexemeComposite.addComponent(symbolComponent);
        });
        return lexemeComposite;
    }
}
