package com.gourianovd.myapp.task;

import com.gourianovd.service.SortByComparator;
import com.gourianovd.texthandler.chainparser.SentenceParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import com.gourianovd.texthandler.service.MarksRemover;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.gourianovd.texthandler.entity.ComponentType.TEXT;
@Slf4j
public class TaskThirteen {
    private String result;

    public String getResult() {
        return result;}

    public TaskThirteen(ArrayList<TextComponent> arrayList, String letter) {
        String letterTask13=letter;
        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser;
        sentenceParser = new SentenceParser();


        Map<String,Integer> map=new HashMap<>();

        while (iter.hasNext()) {
            ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();


            for (TextComponent words : NextSentence) {
                if (words.toString().toLowerCase().contains(letterTask13.toLowerCase())) {
                    String[] mas =(" "+words.toString()+" ").toLowerCase().split(letterTask13.toLowerCase());
                    map.put(words.toString(),mas.length);}
            }
        }


        String result= SortByComparator.sortByComparator(map).keySet().toString();
        result=new MarksRemover().remove(result);

        List<String> sorted = Arrays.stream(result.split("\\s+")).collect(Collectors.toList());
        Collections.reverse(sorted);

        result = new MarksRemover().remove(sorted.toString());//
        this.result=result;
    }

}
