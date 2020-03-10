package com.github.zhujiebing.socketio;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import com.github.zhujiebing.socketio.properties.PushProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 *  配置Socket
 * @author: zjbing
 **/
@Configuration
@Slf4j
@EnableConfigurationProperties(PushProperties.class)
public class SocketioAutoConfiguration {

    @Resource
    private PushProperties pushProperties;

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setPort(pushProperties.getSocketPort());
        config.setUpgradeTimeout(10000);
        config.setPingInterval(pushProperties.getPingInterval());
        config.setPingTimeout(pushProperties.getPingTimeout());
        //生成uuid设置为随机.多个同浏览器标签页发起连接生成clientid不相同
        config.setRandomSession(true);
        config.setAuthorizationListener(data -> {
            /*String token = data.getSingleUrlParam("token");
            log.info("token:{}",token);*/
            return true;
        });
        return new SocketIOServer(config);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}
