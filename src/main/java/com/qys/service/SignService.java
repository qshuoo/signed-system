package com.qys.service;

import java.util.List;

import com.qys.pojo.Sign;

public interface SignService {

	/**
	 * 根据姓名分页查询
	 * @param uname
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<Sign> getSignByUname(String uname, Integer pageNo, Integer pageSize);
	
	/**
	 * 得到所有记录
	 * @return
	 */
	List<Sign> getAllSign();

	/**
	 * 保存记录
	 * @param uname
	 * @param time
	 * @return
	 */
	int saveSign(String uname, String time);

	/**
	 * 根据id删除记录
	 * @param sid
	 * @return
	 */
	int deleteSignById(int sid);

	/**
	 * 得到分页的数量
	 * @param pageSize
	 * @param uname
	 * @return
	 */
	int getPages(int pageSize, String uname);

}
