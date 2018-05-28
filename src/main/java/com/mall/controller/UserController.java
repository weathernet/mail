package com.mall.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.pojo.User;
import com.mall.service.UserService;
import com.mall.utils.IDUtils;

@Controller()
public class UserController {
	String random;
	String phone;
	@Autowired
	private UserService userServise;

	/**
	 * 用户登录注册
	 * 
	 * @param request
	 * @param user
	 * @return
	 */
	@RequestMapping("signin")
	@ResponseBody
	public User Signin(HttpServletRequest request, User user) {
		User userinfo = this.userServise.selectbyphone(user);
		// 把用户的信息存到Session中
		request.setAttribute("userinfo", userinfo);
		phone = user.getPhone();
		random = IDUtils.Random();
		System.out.println("用户的手机号为" + user.getPhone());
		System.out.println(random);
		// 直接登陆
		return userinfo;
	}

	/**
	 * 验证码登陆
	 */
	@RequestMapping("codeServlet")
	@ResponseBody
	public String Validate(HttpServletRequest request) {
		// 成功返回true失败返回false
		if (request.getParameter("code").equals(random)) {
			return "true";
		} else {
			return "false";
		}
	}

	/**
	 * 用户退出
	 * 
	 */
	@RequestMapping("signout")
	public String Signout(HttpServletRequest request) {
		request.getSession().removeAttribute("user");// 清空session信息
		return "main";
	}

	/**
	 * 修改用户的信息
	 * 
	 */
	@RequestMapping("updateuser")
	public void updateuser(HttpServletRequest request, User user) {
		User sessionuser = (User) request.getSession().getAttribute("user");
		user.setUid(sessionuser.getUid());
		this.userServise.updateUser(user);
	}

	@RequestMapping("main")
	public String main() {
		return "main";
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
