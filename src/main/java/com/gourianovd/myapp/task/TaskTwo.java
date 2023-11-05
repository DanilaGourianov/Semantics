package com.gourianovd.myapp.task;

import com.gourianovd.service.SortByComparator;
import com.gourianovd.texthandler.chainparser.SentenceParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.gourianovd.texthandler.entity.ComponentType.LEXEME;

public class TaskTwo {
    @Getter
    private final ArrayList<String> arrayList;

    public TaskTwo(ArrayList<TextComponent> arrayList) {
        Map<String, Integer> map = new HashMap<>();
        for (TextComponent sentence : arrayList) {
            SentenceParser sentenceParser = new SentenceParser();
            map.put(sentence.toString(), sentenceParser.parse(sentence.toString(), new TextComposite(LEXEME)).getComponents().size());
        }
        this.arrayList = new ArrayList<>(SortByComparator.sortByComparator(map).keySet());
    }
}