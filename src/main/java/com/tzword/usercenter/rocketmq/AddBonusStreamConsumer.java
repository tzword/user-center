package com.tzword.usercenter.rocketmq;

import com.tzword.usercenter.dao.user.UserMapper;
import com.tzword.usercenter.domain.dto.messageing.UserAddBonusMsgDTO;
import com.tzword.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * @author jianghy
 * @Description:
 * @date 2021/4/14 20:34
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class AddBonusStreamConsumer {
    private final UserMapper userMapper;

//    @StreamListener(Sink.INPUT)
//    public void receive(String messageBody){
//        log.info("通过stream收到了消息：messageBody:{}",messageBody);
//    }

    @StreamListener(Sink.INPUT)
    public void addBonus(@Payload UserAddBonusMsgDTO userAddBonusMsgDTO) {
        Integer userId = userAddBonusMsgDTO.getUserId();
        User user = userMapper.selectByPrimaryKey(userId);
        Integer bonus = userAddBonusMsgDTO.getBonus();
        log.info("用户id为：{},积分为：{}",userId,bonus);
    }
}
