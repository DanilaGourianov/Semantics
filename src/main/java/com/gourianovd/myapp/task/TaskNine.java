package com.gourianovd.myapp.task;

import com.gourianovd.service.SortByComparator;
import com.gourianovd.texthandler.chainparser.SentenceParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import com.gourianovd.texthandler.service.MarksRemover;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;

import static com.gourianovd.texthandler.entity.ComponentType.TEXT;
@Slf4j
public class TaskNine {

    private String result;

    public String getResult() {
        return result;
    }

    public TaskNine(ArrayList<TextComponent> arrayList, String letter) {
        String letterTask9 = letter;
        Iterator<TextComponent> iter = arrayList.iterator();
        SentenceParser sentenceParser;
        sentenceParser = new SentenceParser();


        Map<String, Integer> map = new HashMap<>();

        while (iter.hasNext()) {
            ArrayList<TextComponent> NextSentence = sentenceParser.parse(iter.next().toString(), new TextComposite(TEXT)).getComponents();

            for (TextComponent words : NextSentence) {
                if (words.toString().toLowerCase().contains(letterTask9.toLowerCase())) {
                    String[] mas = (" " + words.toString() + " ").toLowerCase().split(letterTask9.toLowerCase());
                    map.put(words.toString(), mas.length);
                }
            }
        }
        Map<String, Integer> sortedmap = new HashMap<>();
        sortedmap=SortByComparator.sortByComparator(map);
        int size1;
        String st1;

        log.info(sortedmap+"et\n");
        Iterator<Map.Entry<String, Integer>> iter2 = sortedmap.entrySet().iterator();
        Set<String> set =new HashSet<>();
        Set<String> tmp=new HashSet<>();
                while (iter2.hasNext()) {
                      size1=iter2.next().getValue();
log.info(iter2.next().getKey());
                 st1=new MarksRemover().remove(iter2.next().getKey());
                log.info(st1);

                tmp.add(st1);
                log.info(tmp+"tmp\n");
                    if (iter2.hasNext()){int size2=iter2.next().getValue();
                         if (size1!=size2){
                       set=tmp;
                       log.info(set+" set\n");
                        tmp=new HashSet<>();
                            }
                         else{ tmp.add(iter2.next().getKey());
                             log.info(tmp+"tmp\n");

                              }
                         }

                }
    String result=set.toString()+tmp.toString();
      result = new MarksRemover().remove(result);

        this.result = result;

        }

    }


