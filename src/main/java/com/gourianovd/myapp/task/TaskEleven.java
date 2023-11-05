package com.gourianovd.myapp.task;

import com.gourianovd.texthandler.chainparser.SentenceParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import com.gourianovd.texthandler.service.MarksRemover;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.gourianovd.texthandler.entity.ComponentType.TEXT;
@Slf4j
public class TaskEleven {
    private String result;

    public String getResult() {
        return result;
    }

    public TaskEleven(ArrayList<TextComponent> arrayList, String wordStart, String wordEnd) {
wordStart=" "+wordStart;
wordEnd=" "+wordEnd;
        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser;
        sentenceParser = new SentenceParser();
        Set<String> set = new HashSet<>();
int i=0;
   while (iter.hasNext()) {

       ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();

       String str = NextSentence.toString();
       log.info(NextSentence + " " + i);
       i++;

       int start = str.toLowerCase().indexOf(wordStart.toLowerCase());
       int end = str.toLowerCase().lastIndexOf(wordEnd.toLowerCase());
       log.info(start+"start"+end+"end");
   if (start!=end) {
       String str2 = str.substring(start, end);

       str = str.replace(str2, "");
       set.add(str);
   }

        }
        this.result = new MarksRemover().remove(set.toString());


      //  this.result="!!!+++";
    }
}