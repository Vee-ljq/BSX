package com.ry.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.dto.AddressDto;
import com.ry.dto.BTjgoodsDto;
import com.ry.dto.GoodsDto;
import com.ry.dto.SGood;
import com.ry.dto.slidegoodsDto;
import com.ry.mapper.BAddressMapper;
import com.ry.mapper.BCustomerMapper;
import com.ry.mapper.BGoodsMapper;
import com.ry.mapper.BGoodspicMapper;
import com.ry.mapper.BSlidegoodsMapper;
import com.ry.mapper.BTjgoodsMapper;
import com.ry.mapper.SGoodstypeMapper;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BGoods;
import com.ry.pojo.BGoodsExample;
import com.ry.pojo.BGoodsExample.Criteria;
import com.ry.pojo.BGoodsKey;
import com.ry.pojo.BGoodsWithBLOBs;
import com.ry.pojo.BGoodspic;
import com.ry.pojo.BGoodspicExample;
import com.ry.pojo.BTjgoodsKey;
import com.ry.pojo.BTjgoodsWithBLOBs;
import com.ry.service.GoodsService;
@Service("goodsservice")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private BGoodsMapper mapper;
	
	@Autowired
	private BTjgoodsMapper btjmapper;
	@Autowired
	private BGoodspicMapper bGoodspicMapper;
	
	@Autowired
	private BSlidegoodsMapper bsmapper;
	
	@Autowired
	private SGoodstypeMapper SGoodstypeMapper;
	@Autowired
	private BCustomerMapper cusmapper;
	@Autowired
	private BAddressMapper addmapper;
	
	
	@Override
	public PageInfo<GoodsDto> selectAllOrderType(GoodsDto sg,
			Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<GoodsDto> list = mapper.selectAllOrderTypeOrId(sg);
		return new PageInfo<GoodsDto>(list);
	}

	@Override
	public GoodsDto selectById(Integer id) {
		return mapper.selectById(id);
	}

	@Override
	public boolean updataByPrice(BGoodsWithBLOBs goods) {
		if(mapper.updateByPrimaryKeySelective(goods)==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean updataByTjgoods(BTjgoodsWithBLOBs tjgoods) {
		int insert=0;
		if(tjgoods.getId()==null&&tjgoods.getGoodsid()!=null){
			insert = btjmapper.insert(tjgoods);
		}
			int updateByPrimaryKeySelective = btjmapper.updateByPrimaryKeySelective(tjgoods);
			if(insert==1&&updateByPrimaryKeySelective==1){
				
				return true;
			}
		return false;
	}

	@Override
	public int deleteById(BTjgoodsKey key) {
		 
		return btjmapper.deleteByPrimaryKey(key);
	}

	@Override
	public boolean updateByIdOnStatus(BTjgoodsWithBLOBs btgoods) {
		if(btjmapper.updateByPrimaryKeySelective(btgoods)==1){
			return true;
		};
		return false;
	}

	@Override
	public boolean updateByIds(Integer[] ids) {
		BTjgoodsWithBLOBs bs = new BTjgoodsWithBLOBs();
		bs.setStatus(0);
		int num = 0;
		for(int i=0; i<ids.length;i++){
			bs.setId(ids[i]);
			num += btjmapper.updateByPrimaryKeySelective(bs);
		}
		if(num==ids.length){
			return true;
		}
		return false;
	}

	@Override
	public BGoodsWithBLOBs selectByGoodsId(BGoodsKey key) {
		BGoodsWithBLOBs selectByPrimaryKey = mapper.selectByPrimaryKey(key);
		return selectByPrimaryKey;
	}

	@Override
	public List<slidegoodsDto> selectSlidegoods() {
		List<slidegoodsDto> sllist =  bsmapper.selectSlidegoods();
		return sllist;
	}

	@Override
	public List<BGoods> selectAllGoodsId() {
		BGoodsExample example = new BGoodsExample();
		Criteria createCriteria = example.createCriteria();
		List<BGoods> selectByExample = mapper.selectByExample(example );
		return selectByExample;
	}

	@Override
	public boolean saveDuoPic(BGoodspic bGoodspic) {
		int insertSelective = bGoodspicMapper.insertSelective(bGoodspic);
		if(insertSelective==1){
			return true;
		}else{
			return false;
		}
		
	}

	@Override
	public List<BGoodspic> selectAllPicByGoodsId(Integer id) {
		BGoodspicExample example = new BGoodspicExample();
		com.ry.pojo.BGoodspicExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andGoodsidEqualTo(id);
		List<BGoodspic> selectByExample = bGoodspicMapper.selectByExample(example );
		return selectByExample;
	}



	@Override
	public List<BTjgoodsDto> selectActGoods(Integer status) {
		List<BTjgoodsDto> bt =  btjmapper.selectActGoods(status);
		return bt;
	}

	@Override
	public  List<SGood> selectAllGoods() {
		 List<SGood> gd = SGoodstypeMapper.selectAllGoods();
		return gd;
	}
	//查询商品信息
	@Override
	public GoodsDto selectGoodsById(Integer goodsid) {
	GoodsDto goodsdto = mapper.selectById(goodsid);
	
		return goodsdto;
	}
	//查询用户信息
	@Override
	public BCustomer selectCust(Integer custid) {
		BCustomer cus = cusmapper.selectByPrimaryKey(custid);
		return cus;
	}
	
	//通过custid来查询的地址信息
	@Override
	public List<AddressDto> selectAddrByCusid(Integer custid) {
		List<AddressDto> addrdto1=addmapper.selectAddrByCusid(custid);
		return addrdto1;
	}

	@Override
	public PageInfo<GoodsDto> selectByGoodsName(String goodsname,
			Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<GoodsDto> list = SGoodstypeMapper.selectByGoodsName(goodsname);
		return new PageInfo<GoodsDto>(list);
	}
	@Override
	public PageInfo<BGoodsWithBLOBs> selectByTiaojian(String tiaojian,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		List<BGoodsWithBLOBs> list = mapper.selectByTiaojian(tiaojian);
		PageInfo<BGoodsWithBLOBs> pageInfo = new PageInfo(list);
		return pageInfo;
	}
}
