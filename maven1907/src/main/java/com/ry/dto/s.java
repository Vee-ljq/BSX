package com.ry.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ry.service.GoodsService;
import com.ry.serviceImp.GoodsServiceImpl;
public class s {
	@Autowired
	
	public static void main(String[] args) {
		GoodsService GoodsService = new GoodsServiceImpl();
		List<BTjgoodsDto> sgGoods = GoodsService.selectActGoods(0);
		int a = (int)Math.floor((Math.random()));
		System.out.println(a+"yyyyyyyyyyyyyyyyyyyy");
		}
}
