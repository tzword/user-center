package com.tzword.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @author jianghy
 * @Description:
 * @date 2021/4/14 20:34
 */
@Service
@Slf4j
public class TestStreamListener {
    @StreamListener(Sink.INPUT)
    public void receive(String messageBody){
        log.info("通过stream收到了消息：messageBody:{}",messageBody);
    }
}