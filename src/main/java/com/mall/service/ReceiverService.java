package com.mall.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.mall.mapper.ReceiverMapper;
import com.mall.pojo.Receiver;

@Service
public class ReceiverService {
	@Autowired
	private ReceiverMapper receiverService;

	public List<Receiver> queryAllReceiver(Long userid) {
		// 创建Example
		Example example = new Example(Receiver.class);
		// 创建Criteria
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("uid", userid);
		List<Receiver> selectByExample = this.receiverService.selectByExample(example);
		return selectByExample;

	}

	public void addReceiver(Receiver receiver, Long parseLong) {
		receiver.setUid(parseLong);
		receiver.setCreatedtime(new Date());
		receiver.setUpdatedtime(new Date());
		this.receiverService.insert(receiver);
		
	}

	public void updateReceiver(Receiver receiver) {
		receiver.setUpdatedtime(new Date());
		this.receiverService.updateByPrimaryKeySelective(receiver);
	}
	
	public void deleteReceiver(Receiver receiver) {
		this.receiverService.deleteByPrimaryKey(receiver);	
	}

}
