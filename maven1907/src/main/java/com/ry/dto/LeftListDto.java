package com.ry.dto;

import java.util.List;

import com.ry.pojo.LeftList;

public class LeftListDto extends LeftList {

	private List<LeftList> children;

	public List<LeftList> getChildren() {
		return children;
	}

	public void setChildren(List<LeftList> children) {
		this.children = children;
	}
	
}
