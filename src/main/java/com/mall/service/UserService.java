package com.mall.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mall.mapper.UserMapper;
import com.mall.pojo.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;

	// 根据主键查询数据
	public User queryById(User user) {
		User selectByPrimaryKey = this.userMapper.selectByPrimaryKey(user.getUid());
		return selectByPrimaryKey;

	}

	// 更新用户的数据
	public void updateUser(User user) {
		this.userMapper.updateByPrimaryKeySelective(user);

	}

	public User selectbyphone(User user) {
		// 根据输入框中手机号查询数据库中是否有该数据
		user.setPhone(user.getPhone());
		User selectOne = this.userMapper.selectOne(user);
		if (selectOne == null) {
			// 数据库没有此手机号，创建用户并返回
			this.AddUser(user);
			User selectOne2 = this.userMapper.selectOne(user);
			return selectOne2;
		} else {
			// 数据库存在此手机号，直接返回
			return selectOne;
		}
	}

	// 添加一个用户
	public void AddUser(User user) {
		user.setPhone(user.getPhone());
		user.setCreated(new Date());
		this.userMapper.insert(user);
	}

}
