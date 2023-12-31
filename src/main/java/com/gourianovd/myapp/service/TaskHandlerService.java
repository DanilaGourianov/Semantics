package com.gourianovd.myapp.service;

import com.gourianovd.myapp.dto.TextDto;
import com.gourianovd.myapp.task.*;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.service.MarksRemover;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
@Slf4j
public class TaskHandlerService {

    public static void handleTaskOne(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskOne taskOne = new TaskOne(arrayList);
        String textResult = "";
        String result = taskOne.getResult();

        if (result != null) {
            textResult = textResult.concat("\n\n\t SENTENCE WITH THE LARGEST AMOUNT OF REPEATED WORDS:\n")
                    .concat("\n\t ****************************************************\n")
                    .concat(" \n\t" + result + "\n\n");
        } else {
            textResult = "\n\t NONE SENTENCES WITH REPEATED WORDS \n";
        }
        dto.setText(textResult);
    }

    public static void handleTaskTwo(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskTwo task = new TaskTwo(arrayList);
        String textResult = "";
        ArrayList<String> result = task.getArrayList();
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n \t SENTENCES IN ORDER:\n")
                    .concat("\n\t  ******************\n");
            for (String sentence : result) {
                textResult = textResult.concat("\n\t" + sentence + "\n");
            }
        } else {
            textResult = "\n\t NONE SENTENCES WITH REPEATED WORDS \n";
        }
        dto.setText(textResult);
    }

    public static void handleTaskThree(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskThree task = new TaskThree(arrayList);
        String textResult = "";
        String result = task.getResult();
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n \tDIFFERENT WORDS THAT NOT REPEATED AT ANOTHER SENTENCES\n")
                    .concat("\n\t ****************************************************\n")
                    .concat("\n\t" + result + "\n");//different words
        } else {

            textResult = "\n\t ALL WORDS REPEATED AT ANOTHER SENTENCES \n\n";

        }
        dto.setText(textResult);
    }

    public static void handleTaskFour(TextDto dto, ArrayList<TextComponent> arrayList) {
        int lengthOfWord = dto.getLengthOfWord();
        TaskFour task = new TaskFour(arrayList, lengthOfWord);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN ORDER WITH LENGTH " + lengthOfWord + ":\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS OF SUCH A LENGTH \n\n";

        }
        dto.setText(textResult);
    }

    public static void handleTaskFive(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskFive task = new TaskFive(arrayList);
        String textResult = "";
        String result = task.getResult();
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t REVERSED SENTENCES:\n")
                    .concat("\n ******************\n")
                    .concat("\n" + result + "\n");

        } else {
            textResult = "\n\t NONE SENTENCE TO REVERSE \n\n";
        }
        dto.setText(textResult);
    }

    public static void handleTaskSix(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskSix task = new TaskSix(arrayList);
        String textResult = "";
        ArrayList<String> lexemes = task.getLexems();
        if (!lexemes.isEmpty()) {
            textResult = textResult.concat("\n\n WORD AT ALPHABETICAL ORDER:\n");

            for (String words : lexemes) {
                textResult = textResult.concat("\n\n" + words + "\n");

            }
        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);
    }

    public static void handleTaskSeven(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskSeven task = new TaskSeven(arrayList);
        ArrayList<String> sorted;
        sorted = task.getResult();
        String textResult = "";
        if (!sorted.isEmpty()) {
            for (String words : sorted) {
                textResult = textResult.concat("\n\n" + words + "\t");
            }
        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }

    public static void handleTaskEight(TextDto dto, ArrayList<TextComponent> arrayList) {
        TaskEight task = new TaskEight(arrayList);
        ArrayList<String> sorted;
        sorted = task.getResult();
        String textResult = "";
        MarksRemover marksRemover = new MarksRemover();
        if (!sorted.isEmpty()) {
            for (String wordsWithBeginVowels : sorted) {
                textResult = textResult.concat("\n\n" + marksRemover.remove(wordsWithBeginVowels) + "\t");
            }
        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }
    public static void handleTaskNine(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: alphabetical order
       String letter=dto.getLetter();
        TaskNine task = new TaskNine(arrayList, letter);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN ORDER OF AMOUNT OF " + letter + ":\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS WITH "+letter+" \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskTen(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: user input rewrite
        ArrayList<String> list= new ArrayList<>(Arrays.asList("Dad", "Madam", "Adam", "pull"));
        TaskTen task = new TaskTen(arrayList, list);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN REVERSE ORDER OF AMOUNT\n" +  result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS IN TEXT  \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskEleven(TextDto dto, ArrayList<TextComponent> arrayList) {

        String wordStart = dto.getWordStart();
        String wordEnd = dto.getWordEnd();
        TaskEleven task = new TaskEleven(arrayList,  wordStart , wordEnd);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t SENTENCE WITHOUT MAXIMAL SUBSTRINGS BEGIN WITH " + wordStart+", END WITH "+ wordEnd+"\n"+ result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS IN TEXT  \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskTwelve(TextDto dto, ArrayList<TextComponent> arrayList) {
        int lengthOfWord = dto.getLengthOfWord();
        TaskTwelve task = new TaskTwelve(arrayList, lengthOfWord);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t TEXT WITHOUT WORDS OF LENGTH EQUAL TO " + lengthOfWord + " BEGINS ON CONSTANT:\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS OF SUCH A LENGTH \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskThirteen(TextDto dto, ArrayList<TextComponent> arrayList) {
        //TODO: alphabetical order
        String letter=dto.getLetter();
        TaskThirteen task = new TaskThirteen(arrayList, letter);
        String result = task.getResult();
        String textResult = "";
        if (!result.isEmpty()) {
            textResult = textResult.concat("\n\n\t WORDS IN ORDER OF AMOUNT OF " + letter + ":\n" + result + "\n\n");

        } else {
            textResult = "\n\t NONE WORDS WITH "+letter+" \n\n";

        }
        dto.setText(textResult);
    }
    public static void handleTaskFourteen(TextDto dto, ArrayList<TextComponent> arrayList) {

        TaskFourteen task = new TaskFourteen(arrayList);
        String largestPalindrome = task.getResult();
        String textResult = "";
        if (!largestPalindrome.isEmpty()) {
            textResult = textResult.concat("\n\n THE LARGEST PALINDROME IS:  \n" + largestPalindrome + "\n");

        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }
    public static void handleTaskFifteen(TextDto dto, ArrayList<TextComponent> arrayList) {

        TaskFifteen task = new TaskFifteen(arrayList);
        String newText = task.getResult();
        String textResult = "";
        if (!newText.isEmpty()) {
            textResult = textResult.concat("\n\n THE NEW TEXT IS:  \n" + newText + "\n");

        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }
    public static void handleTaskSixteen(TextDto dto, ArrayList<TextComponent> arrayList) {
        Integer lengthOfWord= dto.getLengthOfWord();
        String subString= dto.getWordStart();
        TaskSixteen task = new TaskSixteen(arrayList,lengthOfWord,subString );
        String newText = task.getResult();
        String textResult = "";
        if (!newText.isEmpty()) {
            textResult = textResult.concat("\n\n THE NEW TEXT IS:  \n" + newText + "\n");

        } else {
            textResult = "NONE";
        }
        dto.setText(textResult);

    }
}
