package com.gourianovd.myapp.service;


import com.gourianovd.myapp.dto.TextDto;
import com.gourianovd.texthandler.chainparser.ParagraphParser;
import com.gourianovd.texthandler.entity.TextComponent;
import com.gourianovd.texthandler.entity.TextComposite;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static com.gourianovd.myapp.service.TaskHandlerService.*;
import static com.gourianovd.texthandler.entity.ComponentType.LEXEME;
@Slf4j
public class TextHandlerService {

    public static void handle(TextDto dto) {
        ParagraphParser paragraphParser = new ParagraphParser();
        ArrayList<TextComponent> arrayList = paragraphParser.parse(dto.getText(), new TextComposite(LEXEME)).getComponents();

        switch (dto.getTaskNumber()) {
            case (1):
                handleTaskOne(dto, arrayList);
                break;
            case (2):
                handleTaskTwo(dto, arrayList);
                break;
            case (3):
                handleTaskThree(dto, arrayList);
                break;
            case (4):
                handleTaskFour(dto, arrayList);
                break;
            case (5):
                handleTaskFive(dto, arrayList);
                break;
            case (6):
                handleTaskSix(dto, arrayList);
                break;
            case (7):
                handleTaskSeven(dto, arrayList);
                break;
            case (8):
                handleTaskEight(dto, arrayList);
                break;
            case (9):
                handleTaskNine(dto, arrayList);
                break;
            case (10):
                handleTaskTen(dto, arrayList);
                break;
            case (11):
                handleTaskEleven(dto, arrayList);
                break;
            case (12):
                handleTaskTwelve(dto, arrayList);
                break;
            case (13):
                handleTaskThirteen(dto, arrayList);
                break;
            case (14):
                handleTaskFourteen(dto, arrayList);
                break;
            case (15):
                handleTaskFifteen(dto, arrayList);
                break;
            case (16):
                handleTaskSixteen(dto, arrayList);
                break;
            default:
                 log.info("Please, 9-11 are under construction. Try type a number 1-8 or 12-16");
                break;
        }
    }

}
