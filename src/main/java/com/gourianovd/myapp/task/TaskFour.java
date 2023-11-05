package com.gourianovd.myapp.task;

import com.gourianovd.service.SortByComparator;
import com.gourianovd.texthandler.chainparser.SentenceParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import com.gourianovd.texthandler.service.MarksRemover;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import static com.gourianovd.texthandler.entity.ComponentType.TEXT;

public class TaskFour {
    private String result;

    public String getResult() {
        return result;
    }

    public TaskFour(ArrayList<TextComponent> arrayList, int lengthOfWord) {

        HashSet<String> differentSentencesWithQuestionSign = new HashSet<>();

        for (TextComponent sentence : arrayList) {
            if (sentence.toString().contains("?")) {

                differentSentencesWithQuestionSign.add(sentence.toString());
            }
        }

        SentenceParser sentenceParser = new SentenceParser();
        HashMap<String, Integer> differentWords = new HashMap<>();

        for (Iterator<String> iter = differentSentencesWithQuestionSign.iterator(); iter.hasNext(); ) {
            String st = iter.next().toString();

            ArrayList<TextComponent> wordsInSentence = new ArrayList<>();

            wordsInSentence = sentenceParser.parse(st, new TextComposite(TEXT)).getComponents();

            for (TextComponent words : wordsInSentence) {

                if (words.toString().trim().length() == lengthOfWord+1) {
                    differentWords.put(words.toString().trim(), words.toString().length());
                }

            }

        }
        String result = SortByComparator.sortByComparator(differentWords).keySet().toString();
        MarksRemover lexemeRemover = new MarksRemover();
        result = lexemeRemover.remove(result);
        this.result = result;
    }
}
