package com.rwkj.dormitory.mapper;

import com.rwkj.dormitory.pojo.SystemAdmin;

public interface SystemAdminMapper {
    public SystemAdmin findByUsername(String username);
}
