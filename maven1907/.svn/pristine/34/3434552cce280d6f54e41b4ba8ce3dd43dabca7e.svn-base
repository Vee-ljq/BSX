package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ry.dto.BcartGoodsDto;
import com.ry.mapper.BCartMapper;
import com.ry.pojo.BCart;
import com.ry.pojo.BCartExample;
import com.ry.pojo.BCartExample.Criteria;
import com.ry.service.BcartService;
@Service("bcartService")
public class BcartServiceImpl implements BcartService {
	@Autowired
	private BCartMapper BCartMapper;

	@Override
	public Integer selectCartCount(Integer id) {
		BCartExample example = new BCartExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCusidEqualTo(id);
		int countByExample = (int)BCartMapper.countByExample(example);
		return countByExample;
	}

	@Override
	public boolean insertGoods(BCart bc) {
		boolean flag = false;
		
		//如果数据库中存在该商品则数量加一
		//查询购物车
		BCartExample example = new BCartExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCusidEqualTo(bc.getCusid());
		createCriteria.andGoodsidEqualTo(bc.getGoodsid());
		List<BCart> selectByExample = BCartMapper.selectByExample(example);
		if(selectByExample.size()!=0){
			for (BCart bCart : selectByExample) {
				bc.setNum(bCart.getNum()+1);
				bc.setId(bCart.getId());
				int updateByPrimaryKeySelective = BCartMapper.updateByPrimaryKeySelective(bc);
				if(updateByPrimaryKeySelective==0){
					flag=false;
				}
			}
		}else{
			int insertSelective = BCartMapper.insertSelective(bc);
			if(insertSelective==1){
				flag=true;
			}
		}
		return flag;
	}

	@Override
	public boolean insertShop(BCart bCart) {
		int insertSelective = BCartMapper.insertSelective(bCart);
		if(insertSelective==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<BcartGoodsDto> selectShopCartByCusid(Integer id) {
		
		List<BcartGoodsDto> bcartGoodsDtos = BCartMapper.selectShopCartByCusid(id);
		return bcartGoodsDtos;
	}

	@Override
	public BCart selectWetherSame(BCart bCart) {
		BCart bb = BCartMapper.selectWetherSame(bCart);
		return bb;
	}

	@Override
	public BCart selectCartByid(Integer id) {
		BCart selectByPrimaryKey = BCartMapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean updateCartBySame(BCart bb1) {
		int updateByPrimaryKeySelective = BCartMapper.updateByPrimaryKeySelective(bb1);
		if(updateByPrimaryKeySelective==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean updateCartById(BCart bCart) {
		int updateByPrimaryKeySelective = BCartMapper.updateByPrimaryKeySelective(bCart);
		if(updateByPrimaryKeySelective==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public boolean deleteCartById(Integer id) {
		int deleteByPrimaryKey = BCartMapper.deleteByPrimaryKey(id);
		if(deleteByPrimaryKey==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public int updateNumById(Integer num, Integer cartid) {
		BCart record=new BCart();
		record.setNum(num);
		record.setId(cartid);
		int in = BCartMapper.updateByPrimaryKeySelective(record);
		return in;
	}
	//通过购物车的id查询相应信息
	@Override
	public BcartGoodsDto selectCartByCartId(Integer cartId) {
		BcartGoodsDto bgDto=BCartMapper.selectCartByCartId(cartId);
		return bgDto;
	}

}
