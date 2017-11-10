package com.qys.web.action;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qys.pojo.User;
import com.qys.service.UserService;

@Controller
@SessionAttributes(value = {"loginUser"})
public class UserController {
	
	@Autowired
	private UserService service;
	
	/**
	 * 登录
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user, Model model) {
		Subject subject = SecurityUtils.getSubject();
		String uname = user.getUname();
		String upassword = user.getUpassword();
		UsernamePasswordToken token = new UsernamePasswordToken(uname, upassword);
		subject.login(token);
		User loginUser = service.getUserByNameAndPwd(user);
		model.addAttribute("loginUser", loginUser);
		return "redirect:main.jsp";
	}

}
