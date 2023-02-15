package com.rwkj.dormitory.dto;

import lombok.Data;

/**
 * 将登录情况封装为AccountDto
 * @param <T>
 */
@Data
public class AccountDto<T> {
    /**
     * -1 用户名错误
     * -2 密码错误
     * 0 登录成功
     */
    private Integer code;
    private T admin;
}
