package com.ry.dto;

import java.util.List;

import com.ry.pojo.TreeNode;

public class TreeNodeDto extends TreeNode {

	private List<TreeNode> children;

	public List<TreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	
}
