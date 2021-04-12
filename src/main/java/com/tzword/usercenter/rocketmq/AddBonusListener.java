package com.tzword.usercenter.rocketmq;

import com.tzword.usercenter.dao.user.UserMapper;
import com.tzword.usercenter.domain.dto.messageing.UserAddBonusMsgDTO;
import com.tzword.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jianghy
 * @Description:
 * @date 2021/4/12 21:34
 */
@Service
@RocketMQMessageListener(consumerGroup = "consume-group", topic = "add-bonus")
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Slf4j
public class AddBonusListener implements RocketMQListener<UserAddBonusMsgDTO> {

    private final UserMapper userMapper;

    @Override
    public void onMessage(UserAddBonusMsgDTO userAddBonusMsgDTO) {
        Integer userId = userAddBonusMsgDTO.getUserId();
        User user = userMapper.selectByPrimaryKey(userId);
        Integer bonus = userAddBonusMsgDTO.getBonus();
        log.info("用户id为：{},积分为：{}",userId,bonus);
    }
}
