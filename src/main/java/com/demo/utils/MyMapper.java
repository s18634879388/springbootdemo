package com.demo.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by shixiaoqi on 2017/8/17.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {

}
