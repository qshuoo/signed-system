package com.qys.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qys.dao.SignMapper;
import com.qys.pojo.Sign;
import com.qys.service.SignService;

import sun.util.calendar.BaseCalendar.Date;
import sun.util.resources.cldr.ne.LocaleNames_ne;

@Service
@Transactional
public class SignServiceImpl implements SignService{

	@Autowired
	private SignMapper mapper;
	
	@Override
	public List<Sign> getSignByUname(String uname, Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		pageNo = (pageNo - 1) * pageSize;
		HashMap<String, Object> map = new HashMap<>();
		map.put("uname", uname);
		map.put("pageNo", pageNo);
		map.put("pageSize", pageSize);
		
		return mapper.getSignByUname(map);
	}
	
	@Override
	public List<Sign> getAllSign() {
		// TODO Auto-generated method stub
		return mapper.getAllSign();
	}

	@Override
	public int saveSign(String uname, String time) {
		// TODO Auto-generated method stub
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat format2 = new SimpleDateFormat("HH");
		String data = format1.format(Long.valueOf(time));
		String hour = format2.format(Long.valueOf(time));
		Sign sign = new Sign();
		sign.setUname(uname);
		sign.setStime(data);
		if (Integer.valueOf(hour) >= 8) {
			sign.setStatus(0);
		} else {
			sign.setStatus(1);
		}
		int rows = mapper.insert(sign);
		return rows <= 0 ? -1 : rows;
	}

	@Override
	public int deleteSignById(int sid) {
		// TODO Auto-generated method stub
		int rows = mapper.deleteByPrimaryKey(sid);
		return rows <= 0 ? -1 : rows;
	}
	
	@Override
	public int getPages(int pageSize, String uname) {
		// TODO Auto-generated method stub
		Sign sign = new Sign();
		sign.setUname(uname);
		int count = mapper.getSignCount(sign);
		return (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
	}
	
}
