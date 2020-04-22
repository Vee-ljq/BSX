package com.ry.dto;

import java.util.List;

import com.ry.pojo.BComment;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BGoods;

public class CommentDto extends BComment {

	private BCustomer customer;
	private BGoods goods;
	List<BComment> commentlist;
	public BCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(BCustomer customer) {
		this.customer = customer;
	}
	public BGoods getGoods() {
		return goods;
	}
	public void setGoods(BGoods goods) {
		this.goods = goods;
	}
	public List<BComment> getCommentlist() {
		return commentlist;
	}
	public void setCommentlist(List<BComment> commentlist) {
		this.commentlist = commentlist;
	}
	
	
}
