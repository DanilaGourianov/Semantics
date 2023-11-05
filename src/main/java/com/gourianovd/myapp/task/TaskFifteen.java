package com.gourianovd.myapp.task;

import com.gourianovd.texthandler.chainparser.SentenceParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import com.gourianovd.texthandler.service.MarksRemover;

import java.util.*;

import static com.gourianovd.texthandler.entity.ComponentType.TEXT;

public class TaskFifteen {
    private String result;

    public String getResult() {
        return result;
    }

    public TaskFifteen(ArrayList<TextComponent> arrayList) {

        SentenceParser sentenceParser;//разбиваем на слова
        ArrayList<TextComponent> wordsInSentence = new ArrayList<>();
        String st="";
        ArrayList<String> newText=new ArrayList<>();
                //TextComposite newText=new TextComposite(TEXT);
        for (
                TextComponent sentence : arrayList) {

                sentenceParser = new SentenceParser();//вопросительные несовпадающие предложнеия складываем в мэп: предложение+ его длина (количество слов)

            wordsInSentence = sentenceParser.parse(sentence.toString(), new TextComposite(TEXT)).getComponents();


        for (Iterator<TextComponent> iter = wordsInSentence.iterator(); iter.hasNext(); ) {
             st = iter.next().toString().trim();

             String firstLetter=st.charAt(0)+"";
             st=st.replaceAll(firstLetter.toLowerCase(),"");
             if (firstLetter==firstLetter.toLowerCase()) {
                 st = firstLetter + st;
             }
             newText.add(st);
            }

        }
        String result=newText.toString();
        result=result.replaceAll(",,","\u2764");
        result=new MarksRemover().remove(result);
        result=result.replaceAll("\u2764",",");
        this.result=result;

    }
}
