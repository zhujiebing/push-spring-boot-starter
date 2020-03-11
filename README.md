## 接入方式
1. 加入依赖
```java
<dependency>
    <groupId>com.github.zhujiebing</groupId>
    <artifactId>push-spring-boot-starter</artifactId>
    <version>2.3</version>
</dependency>
```
2. 加入配置
```java
push:
  socket-port: 9099    #socket端口
  ping-interval: 60000 #Ping消息间隔（毫秒）
  ping-timeout: 180000 #Ping消息超时时间（毫秒）
```
