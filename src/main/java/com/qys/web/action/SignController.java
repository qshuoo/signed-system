package com.qys.web.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qys.pojo.Sign;
import com.qys.pojo.User;
import com.qys.service.SignService;

@Controller
public class SignController {

	@Autowired
	private SignService service;

	/**
	 * 根据姓名分页得到记录
	 * @param uname
	 * @param pageNo
	 * @param pageSize
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequiresAuthentication
	@RequestMapping(value = { "/sign" }, method = { RequestMethod.GET })
	public List<Sign> getSignByUnameLimit(String uname, int pageNo, int pageSize, HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.hasRole("employee")) {
			User user = (User) session.getAttribute("loginUser");
			uname = user.getUname();
		}
		List<Sign> signs = null;
		signs = service.getSignByUname(uname, pageNo, pageSize);
		return signs;
	}

	/**
	 * 插入记录
	 * @param uname
	 * @param time
	 * @return
	 */
	@ResponseBody
	@RequiresRoles(value = { "employee", "manager" }, logical = Logical.OR)
	@RequestMapping(value = { "/sign" }, method = { RequestMethod.POST })
	public int insertSign(String uname, String time) {
		int rows = service.saveSign(uname, time);
		return rows;
	}

	/**
	 * 删除记录
	 * @param sid
	 * @return
	 */
	@ResponseBody
	@RequiresRoles(value = { "root" })
	@RequestMapping(value = { "/sign/{sid}" }, method = RequestMethod.DELETE)
	public int deleteSign(@PathVariable(name = "sid") Integer sid) {
		int rows = service.deleteSignById(sid);
		return rows;
	}

	/**
	 * 得到分页数
	 * @param pageSize
	 * @param uname
	 * @param session
	 * @return
	 */
	@RequiresAuthentication
	@ResponseBody
	@RequestMapping(value = "/page/{pageSize}", method = RequestMethod.GET)
	public int getUserPages(@PathVariable("pageSize") int pageSize, String uname,HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.hasRole("employee")) {
			User user = (User) session.getAttribute("loginUser");
			uname = user.getUname();
		}
		int pages = service.getPages(pageSize , uname);
		return pages;
	}

}
