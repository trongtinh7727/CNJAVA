package com.lab03.dao;

import com.lab03.mapper.RowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface genericDAO <T>{
    <T>List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    int update(String sql,Object... parameters);
    Long insert(String sql,Object... parameters);

}
