package com.qys.dao;

import java.util.HashMap;
import java.util.List;

import com.qys.pojo.Sign;
import com.sun.javafx.collections.MappingChange.Map;

public interface SignMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);

    /**
     * 根据姓名分页查询
     * @param map
     * @return
     */
	List<Sign> getSignByUname(HashMap<String, Object> map);

	/**
	 * 得到所有记录
	 * @return
	 */
	List<Sign> getAllSign();

	/**
	 * 得到记录的数量
	 * @param sign
	 * @return
	 */
	int getSignCount(Sign sign);
}