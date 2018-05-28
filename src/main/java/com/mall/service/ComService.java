package com.mall.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.mapper.ComMapper;
import com.mall.pojo.Commodity;

@Service
public class ComService {
	@Autowired
	private ComMapper comMapper;

	// 查询所有的商品
	public List<Commodity> showAll() {
		List<Commodity> select = this.comMapper.select(null);
		return select;
	}

	/**
	 * 添加商品到购物车
	 * 判断加入的商品在原有的购物车是否存在，
	 * 存在商品数量相加，不存在直接写入
	 */
	public Commodity addCom(HttpServletRequest rerquest, Long id) {

		Commodity record = new Commodity();
		Commodity cart = this.comMapper.selectOne(record);
		if (null == cart) {
			// 购物车不存在该商品

		} else {
			//购物车存在该商品，该商品数量相加，默认为1.
		}

		rerquest.setAttribute("cart", cart);

		return cart;

	}
}
