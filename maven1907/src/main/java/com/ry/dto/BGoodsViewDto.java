package com.ry.dto;

import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BGoodsview;
import com.ry.pojo.SGoodstype;

public class BGoodsViewDto extends BGoodsview{
	private BGoods bGoods;
	private BGoodsWithBLOBs bGoodsWithBLOBs;
	private SGoodstype sGoodstype;
	
	

	public SGoodstype getsGoodstype() {
		return sGoodstype;
	}

	public void setsGoodstype(SGoodstype sGoodstype) {
		this.sGoodstype = sGoodstype;
	}

	public BGoodsWithBLOBs getbGoodsWithBLOBs() {
		return bGoodsWithBLOBs;
	}

	public void setbGoodsWithBLOBs(BGoodsWithBLOBs bGoodsWithBLOBs) {
		this.bGoodsWithBLOBs = bGoodsWithBLOBs;
	}

	public BGoods getbGoods() {
		return bGoods;
	}

	public void setbGoods(BGoods bGoods) {
		this.bGoods = bGoods;
	}
	

}
