package com.tzword.usercenter.annotation;

import java.lang.annotation.*;

/**
 * @author jianghy
 * @Description:
 * @date 2021/4/19 20:31
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckLogin {
}
