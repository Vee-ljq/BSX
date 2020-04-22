package com.ry.dto;

import java.util.List;

import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BGoods;
import com.ry.pojo.BTjgoods;
import com.ry.pojo.SGoodstype;
import com.ry.pojo.SUser;

public class SGood extends SGoodstype{
	private SUser user;
	private BGoods bgoods;
	private SGoodstype sgtype;
	//在扩展类定义一个商品名字
		private String sp;
		
	private List<BGoods> Lbgoods;
	
	private BTjgoods bjgoods;
	
	private BFloorgoods bflgoods;
	
	
	
	
	
	public BFloorgoods getBflgoods() {
		return bflgoods;
	}
	public void setBflgoods(BFloorgoods bflgoods) {
		this.bflgoods = bflgoods;
	}
	public BTjgoods getBjgoods() {
		return bjgoods;
	}
	public void setBjgoods(BTjgoods bjgoods) {
		this.bjgoods = bjgoods;
	}
	public List<BGoods> getLbgoods() {
		return Lbgoods;
	}
	public void setLbgoods(List<BGoods> lbgoods) {
		Lbgoods = lbgoods;
	}
	public String getSp() {
		return sp;
	}
	public SGoodstype getSgtype() {
		return sgtype;
	}
	public void setSgtype(SGoodstype sgtype) {
		this.sgtype = sgtype;
	}
	public void setSp(String sp) {
		this.sp = sp;
	}
	
	public SUser getUser() {
		return user;
	}
	public void setUser(SUser user) {
		this.user = user;
	}
	public BGoods getBgoods() {
		return bgoods;
	}
	public void setBgoods(BGoods bgoods) {
		this.bgoods = bgoods;
	}
	
	
}
