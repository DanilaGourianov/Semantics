package com.gourianovd.myapp;

import com.gourianovd.myapp.client.ExampleClient;
import com.gourianovd.myapp.constants.ClientConstants;
import com.gourianovd.myapp.dto.TextDto;
import com.gourianovd.myapp.dto.UserInputDto;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class AppClient {

    private static final String CLIENT_IP = "127.0.0.1";
    private static final Integer SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        log.info("Client starting...");
        ExampleClient client = new ExampleClient();
        client.startConnection(CLIENT_IP, SERVER_PORT);
        System.out.println(ClientConstants.USER_CHOOSE);
        BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in));
        Integer taskNumber = Integer.valueOf(inputUser.readLine());
        Integer lengthOfWord = 5;
        String letter = "a";
        String wordStart = "a";
        String wordEnd = "z";
        switch (taskNumber) {
            case (4):
            case (12):
                System.out.println("Please, enter a length of word");
                lengthOfWord = Integer.valueOf(inputUser.readLine());
                break;
            case (9):
            case (13):
                System.out.println("Please, enter a letter");
                letter = inputUser.readLine().trim();
                break;
            case (11):
                System.out.println("Please, enter word to start with");
                wordStart = inputUser.readLine().trim();
                System.out.println("Please, enter word to end with");
                wordEnd = inputUser.readLine().trim();
                break;
            case (16):
                System.out.println("Please, enter a length of word");
                lengthOfWord = Integer.valueOf(inputUser.readLine());
                System.out.println("Please, enter a substring");
                wordStart = inputUser.readLine().trim();
        }

        UserInputDto request = new UserInputDto(taskNumber, lengthOfWord, letter, wordStart, wordEnd);
        TextDto response = client.sendMessage(request);
        log.info("Result is: {}", response.getText());
    }
}
