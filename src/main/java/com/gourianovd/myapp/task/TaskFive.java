package com.gourianovd.myapp.task;

import com.gourianovd.texthandler.chainparser.SentenceParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import com.gourianovd.texthandler.service.MarksRemover;

import java.util.ArrayList;

import static com.gourianovd.texthandler.entity.ComponentType.LEXEME;
import static com.gourianovd.texthandler.entity.ComponentType.TEXT;

public class TaskFive {
    private final String result;

    public String getResult() {
        return result;
    }

    public TaskFive(ArrayList<TextComponent> arrayList) {

        ArrayList<TextComponent> arrayList2 = new ArrayList<>();
        SentenceParser sentenceParser;
        String sentenceReverse = "";
        MarksRemover marksRemover = new MarksRemover();

        for (TextComponent sentence : arrayList) {
            sentenceParser = new SentenceParser();
            arrayList2 = sentenceParser.parse(sentence.toString(), new TextComposite(LEXEME)).getComponents();
            sentenceReverse += "\t " + marksRemover.remove(arrayList2.toArray()[arrayList2.size() - 1].toString());

            TextComposite sentenceReversed = new TextComposite(TEXT);
            for (int i = 1; i < arrayList2.size() - 1; i++) {

                sentenceReverse += marksRemover.remove(arrayList2.toArray()[i].toString());
            }
            if (arrayList2.toArray().length > 1) {
                sentenceReverse += " " + marksRemover.remove(arrayList2.toArray()[0].toString());
            }
            sentenceReverse += " " + sentenceReversed + " \n";

        }
        this.result = sentenceReverse;

    }
}
