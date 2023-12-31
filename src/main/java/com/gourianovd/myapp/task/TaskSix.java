package com.gourianovd.myapp.task;

import com.gourianovd.texthandler.chainparser.ParagraphParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import com.gourianovd.texthandler.service.MarksRemover;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static com.gourianovd.texthandler.entity.ComponentType.TEXT;

public class TaskSix {
    private ArrayList<String> lexems;
    public  ArrayList<String> getLexems(){
        return lexems;
    }

    public TaskSix(ArrayList<TextComponent> Sentences) {

        TextComposite SentencesToSort = new TextComposite(TEXT);
        ParagraphParser paragraphParser = new ParagraphParser();
        TextComposite textComposite = new TextComposite();
        for (TextComponent words : Sentences) {
            SentencesToSort.addComponent(words);
            textComposite.addComponent(paragraphParser.parse(words.toString(), new TextComposite(TEXT)));

        }

        TreeMap<Character, ArrayList<String>> lexems = addSymbols();
        for (
                TextComponent paragraphComponent : textComposite.getComponents()) {
            for (TextComponent sentenceComponent : paragraphComponent.getComponents()) {
                for (TextComponent lexemeComponent : sentenceComponent.getComponents()) {
                    String lexem = lexemeComponent.toString().trim();
                    char firstSymbol = lexem.toLowerCase().charAt(0);
                    if (Character.isLetter(firstSymbol)) {
                        lexems.get(firstSymbol).add(lexem);
                    }
                }
            }
        }

        ArrayList<String> sortedWords=new ArrayList<>();
        for (Map.Entry<Character, ArrayList<String>> entry : lexems.entrySet()) {
            entry.getValue().sort(Comparator.naturalOrder());
            if (!entry.getValue().isEmpty()) {
                String LexemeRemove =  entry.getValue().toString();
                String LexemeRemoved=new MarksRemover().remove(LexemeRemove);
                sortedWords.add(LexemeRemoved);
            }
        }
        this.lexems=sortedWords;    }

        private TreeMap<Character, ArrayList<String>> addSymbols () {
        TreeMap<Character, ArrayList<String>> lexems = new TreeMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            lexems.put(c, new ArrayList<>());
        }
        return lexems;
    }
}
