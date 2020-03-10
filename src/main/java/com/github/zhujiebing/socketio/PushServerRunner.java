package com.github.zhujiebing.socketio;

import com.corundumstudio.socketio.SocketIOServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * start pushserver
 * @author: zjbing
 **/
@Component
@Order(1)
@Slf4j
public class PushServerRunner implements CommandLineRunner {

    private final SocketIOServer server;

    @Autowired
    public PushServerRunner(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void run(String... args) {
        log.info("server begin running ......");
        server.start();
    }
}
