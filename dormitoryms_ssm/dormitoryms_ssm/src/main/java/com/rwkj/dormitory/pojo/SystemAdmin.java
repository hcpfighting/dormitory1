package com.rwkj.dormitory.pojo;

import lombok.Data;

/**
 * 系统管理员类
 */
@Data
public class SystemAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String telephone;
}
