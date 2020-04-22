package com.ry.dto;

import java.util.List;

import com.ry.pojo.BCustomer;
import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BGoods;
import com.ry.pojo.BTjgoods;
import com.ry.pojo.SGoodstype;

public class GoodsDto extends BGoods {

	private BTjgoods bjgoods;
	
	private SGoodstype SGoodstype;
	
	private BCustomer BCustomer;
	
	private Integer type;
	
	private BFloorgoods bflgoods;
	
	private String typename;
	
	private List<BGoods> goodslist;
	

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public List<BGoods> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(List<BGoods> goodslist) {
		this.goodslist = goodslist;
	}

	public BFloorgoods getBflgoods() {
		return bflgoods;
	}

	public void setBflgoods(BFloorgoods bflgoods) {
		this.bflgoods = bflgoods;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BCustomer getBCustomer() {
		return BCustomer;
	}

	public void setBCustomer(BCustomer bCustomer) {
		BCustomer = bCustomer;
	}

	public BTjgoods getBjgoods() {
		return bjgoods;
	}

	public void setBjgoods(BTjgoods bjgoods) {
		this.bjgoods = bjgoods;
	}

	public SGoodstype getSGoodstype() {
		return SGoodstype;
	}

	public void setSGoodstype(SGoodstype sGoodstype) {
		SGoodstype = sGoodstype;
	}
	
	
}
