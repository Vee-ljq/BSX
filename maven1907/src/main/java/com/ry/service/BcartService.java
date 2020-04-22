package com.ry.service;

import java.util.List;

import com.ry.dto.BcartGoodsDto;
import com.ry.pojo.BCart;

public interface BcartService {

	/**查询用户购物车商品数
	 * @param id
	 * @return
	 */
	Integer selectCartCount(Integer id);

	/**插入商品
	 * @param goodsid
	 * @return
	 */
	boolean insertGoods(BCart bc);
	/**
	 * 
	 * @param bCart
	 * @return
	 */
	boolean insertShop(BCart bCart);
	/**
	 * 通过用户的id来查询购物车该用户所添加的商品
	 * @param id
	 * @return
	 */
	List<BcartGoodsDto> selectShopCartByCusid(Integer id);
	/**
	 * 添加购物车时判断数据库表中是否有一样的商品
	 * @param bCart
	 * @return
	 */
	BCart selectWetherSame(BCart bCart);
	/**
	 * 通过购物车的id来查询一条购物车信息
	 * @param id
	 * @return
	 */
	BCart selectCartByid(Integer id);
	/**
	 * 通过购物车的id更新数据库中的数量和时间
	 * @param bb1
	 * @return
	 */
	boolean updateCartBySame(BCart bb1);
	/**
	 * 通过购物车的id将购物车中的口味、包装、数量进行一个修改
	 * @param bCart
	 * @return
	 */
	boolean updateCartById(BCart bCart);
	/**
	 * 将数据库中已存在属性的id删除掉
	 * @param id
	 * @return
	 */
	boolean deleteCartById(Integer id);
//结算页面修改商品数量
	int updateNumById(Integer num, Integer cartid);
	//通过购物车的id查询相应信息
	BcartGoodsDto selectCartByCartId(Integer cartId);

}
