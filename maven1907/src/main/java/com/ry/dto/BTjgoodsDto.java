package com.ry.dto;

import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BGoods;
import com.ry.pojo.BTjgoods;
import com.ry.pojo.BTjgoodsWithBLOBs;
import com.ry.pojo.SGoodstype;


public class BTjgoodsDto extends BTjgoods{


	private BTjgoodsWithBLOBs context;

	private BGoods goods;

	private SGoodstype goodtype;
	private String goodsname;

	private BFloorgoods bfgoods;

	
	public BTjgoodsWithBLOBs getContext() {
		return context;

	}
	public void setContext(BTjgoodsWithBLOBs context) {
		this.context = context;
	}

	public BFloorgoods getBfgoods() {
		return bfgoods;
	}

	public void setBfgoods(BFloorgoods bfgoods) {
		this.bfgoods = bfgoods;
	}


	public BGoods getGoods() {
		return goods;
	}
	public void setGoods(BGoods goods) {
		this.goods = goods;
	}
	public SGoodstype getGoodtype() {
		return goodtype;
	}
	public void setGoodtype(SGoodstype goodtype) {
		this.goodtype = goodtype;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}


	
	
	

	
	

}
