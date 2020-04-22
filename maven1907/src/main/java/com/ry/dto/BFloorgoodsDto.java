package com.ry.dto;

import com.ry.pojo.BFloorgoods;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BTjgoods;
import com.ry.pojo.SGoodstype;

public class BFloorgoodsDto extends BFloorgoods {

	private BGoods bGoods;
	private BTjgoods btjgoods;
	private SGoodstype sgoodstype;
	private BGoodsWithBLOBs bwb;
	public BGoods getbGoods() {
		return bGoods;
	}
	public void setbGoods(BGoods bGoods) {
		this.bGoods = bGoods;
	}
	public BTjgoods getBtjgoods() {
		return btjgoods;
	}
	public void setBtjgoods(BTjgoods btjgoods) {
		this.btjgoods = btjgoods;
	}
	public SGoodstype getSgoodstype() {
		return sgoodstype;
	}
	public void setSgoodstype(SGoodstype sgoodstype) {
		this.sgoodstype = sgoodstype;
	}
	public BGoodsWithBLOBs getBwb() {
		return bwb;
	}
	public void setBwb(BGoodsWithBLOBs bwb) {
		this.bwb = bwb;
	}
	
	
}
