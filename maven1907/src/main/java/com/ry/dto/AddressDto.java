package com.ry.dto;

import com.ry.pojo.AreaData;
import com.ry.pojo.BAddress;
import com.ry.pojo.BCustomer;
import com.ry.pojo.ViewAddr;

public class AddressDto extends BAddress{
	private String proname;
	private String cityname;
	private String xianname;
	
	public String getProname() {
		return proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getXianname() {
		return xianname;
	}

	public void setXianname(String xianname) {
		this.xianname = xianname;
	}

	private AreaData AreaData;
	private BCustomer customer;
	private AreaData aData1;
	private AreaData aData2;
	private AreaData aData3;
	
	public BCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(BCustomer customer) {
		this.customer = customer;
	}

	public AreaData getaData1() {
		return aData1;
	}

	public void setaData1(AreaData aData1) {
		this.aData1 = aData1;
	}

	public AreaData getaData2() {
		return aData2;
	}

	public void setaData2(AreaData aData2) {
		this.aData2 = aData2;
	}

	public AreaData getaData3() {
		return aData3;
	}

	public void setaData3(AreaData aData3) {
		this.aData3 = aData3;
	}

	public AreaData getAreaData() {
		return AreaData;
	}

	public void setAreaData(AreaData areaData) {
		AreaData = areaData;
	}

}
