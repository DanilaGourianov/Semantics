package com.gourianovd.myapp;

import com.gourianovd.myapp.server.MultiServer;
import com.gourianovd.myapp.server.SingleServer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppServer {

    private static final Integer SERVER_PORT = 8888;

    public static void main(String[] args) {
        log.info("Server starting...");
        //MultiServer server = new MultiServer();
       SingleServer server = new SingleServer();
        server.start(SERVER_PORT);
    }

}

