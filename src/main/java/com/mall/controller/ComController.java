package com.mall.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.pojo.Commodity;
import com.mall.service.ComService;

@Controller
public class ComController {
	@Autowired
	private ComService comService;

	// 查询所有的商品
	@RequestMapping("showall")
	@ResponseBody
	public List<Commodity> showAll() {
		List<Commodity> showAll = this.comService.showAll();
		return showAll;
	}

	// 添加物品到购物车

	@RequestMapping("addcart")
	public void AddCart(Long id) {

	}

}
