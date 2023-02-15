package com.rwkj.dormitory.service;

import com.rwkj.dormitory.pojo.Moveout;

import java.util.List;

public interface MoveoutService {
    public List<Moveout> list();
    public List<Moveout> search(String key,String value);
}
