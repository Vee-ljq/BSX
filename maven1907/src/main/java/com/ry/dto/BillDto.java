package com.ry.dto;

import java.util.List;

import com.ry.pojo.BGoods;
import com.ry.pojo.BOrderdetail;
import com.ry.pojo.BOrdermain;

public class BillDto extends BOrdermain{
	private List<BOrderdetail> BOrderdetail;
	
	private BGoods BGoods;
	
	private Integer sum;
	



	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public List<BOrderdetail> getBOrderdetail() {
		return BOrderdetail;
	}

	public void setBOrderdetail(List<BOrderdetail> bOrderdetail) {
		BOrderdetail = bOrderdetail;
	}

	public BGoods getBGoods() {
		return BGoods;
	}

	public void setBGoods(BGoods bGoods) {
		BGoods = bGoods;
	}
	
	
	

}
