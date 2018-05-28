package com.mall.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mall.pojo.Receiver;
import com.mall.pojo.User;
import com.mall.service.ReceiverService;
/**
 * 收货地址Controller
 * @author Administrator
 *
 */
@Controller
public class ReceiverController {
	@Autowired
	private ReceiverService receiverService;
	Long parseLong;
	// 查询当前用户的所有的收货地址
	@RequestMapping("queryreceiver")
	@ResponseBody
	public List<Receiver> queryAllReceiver(HttpServletRequest request) {
		//从Session获取当前用户的id
	    User user= (User) request.getSession().getAttribute("user");
	    parseLong = user.getUid();
		List<Receiver> queryAllReceiver = this.receiverService.queryAllReceiver(parseLong);
		return queryAllReceiver;
	}
	//新增用戶地址
	@RequestMapping("addreceiver")
	public String addReceiver(Receiver receiver)  {
		this.receiverService.addReceiver(receiver,parseLong);
		return "index";
	}
	//修改用戶地址
	@RequestMapping("updateReceiver")
	public void updateReceiver(Receiver receiver) {
		this.receiverService.updateReceiver(receiver);
	}
	//刪除用戶的地址
	@RequestMapping("deleteReceiver")
	public void deleteReceiver(Receiver receiver) {
		this.receiverService.deleteReceiver(receiver);
	}
}
