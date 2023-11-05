package com.gourianovd.texthandler.service;

import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;

import java.util.Iterator;


public class LexemeRemover {
    public void remove(TextComposite textComposite, int lexemeLength, char firstSymbol) {
        for (TextComponent paragraphComponent: textComposite.getComponents()) {
            for (TextComponent sentenceComponent: paragraphComponent.getComponents()) {
                Iterator iterator = sentenceComponent.getComponents().iterator();
                while (iterator.hasNext()){
                    TextComponent lexemeComposite = (TextComponent) iterator.next();
                    if (lexemeComposite.toString().length() == lexemeLength && lexemeComposite.toString().trim().charAt(0) == firstSymbol) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
