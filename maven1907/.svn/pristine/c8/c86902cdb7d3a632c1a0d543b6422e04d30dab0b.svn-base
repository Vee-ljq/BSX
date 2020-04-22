package com.ry.serviceImp;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ry.mapper.BCustomerMapper;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BCustomerExample;
import com.ry.pojo.BCustomerExample.Criteria;
import com.ry.service.IndexWebService;
import com.ry.utils.MD5Utils;
import com.ry.utils.NowDate;
@Service
public class IndexWebServiceImp implements IndexWebService{
	@Autowired
private BCustomerMapper mapper;
	
	/**
	 * 登陆时更新登陆时间，并插入数据库
	 */
	@Override
	public BCustomer pwd(BCustomer customer) {
		
		/*boolean flg=false;*/
		BCustomer selectLogin2 =null;
		
		
		int selectLogin = mapper.selectLogin(customer);
		if(selectLogin>0){
			
			/*if(flg=true){*/
				/*BCustomerExample example=new BCustomerExample();
				Criteria createCriteria = example.createCriteria();
				if(customer!=null){
					if(customer.getNickname()!=null){
					createCriteria.andNicknameEqualTo(customer.getNickname());
					}else {
						createCriteria.andMobileEqualTo(customer.getMobile());
					}
					createCriteria.andPwdEqualTo(customer.getPwd());
					}
				
				List<BCustomer> selectByExample = mapper.selectByExample(example);
				 bCustomer = selectByExample.get(0);*/
				selectLogin2 = mapper.selectLogin2(customer);
				//获取系统时间
				long l=System.currentTimeMillis();
				Date date=new Date(l);
				SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String format = d.format(date);
				
				selectLogin2.setLastlogindate(format);
				int updateByPrimaryKeySelective = mapper.updateByPrimaryKeySelective(selectLogin2);
				if(updateByPrimaryKeySelective>0){
					System.out.println("登陆时间插入成功");
				}
				
			
			
		}
		return selectLogin2;
	}
	/**
	 * 通过用户名及密码查询该用户所有信息
	 * 
	 */
/*	@Override
	public BCustomer selectCustomer(BCustomer customer) {
		BCustomerExample example=new BCustomerExample();
		Criteria createCriteria = example.createCriteria();
		//如果名字为空，就测试手机号
		if(customer!=null){
		if(customer.getNickname()!=null){
		createCriteria.andNicknameEqualTo(customer.getNickname());
		}else {
			createCriteria.andMobileEqualTo(customer.getMobile());
		}
		createCriteria.andPwdEqualTo(customer.getPwd());
		}
		List<BCustomer> selectByExample = mapper.selectByExample(example);
		BCustomer bCustomer = selectByExample.get(0);
		
		return bCustomer;
	}*/
	/**
	 * 更改用户信息
	 * 
	 */
	@Override
	public boolean updateCust(BCustomer customer) {
		boolean status=false;
		int updateByPrimaryKey = mapper.updateByPrimaryKeySelective(customer);
		if(updateByPrimaryKey>0){
			status=true;
		}
		
		return status;
	}
	@Override
	public List<BCustomer> selectCustomerAll() {
		
		List<BCustomer> selectByExample = mapper.selectByExample(null);
		
		
		return selectByExample;
	}
	//分页带模糊查询
	@Override
	public PageInfo<BCustomer> selectByPage(BCustomer org, Integer pageNum,
			Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		BCustomerExample example=new BCustomerExample();
		example.setOrderByClause("id DESC");
		Criteria createCriteria = example.createCriteria();
		List<BCustomer> selectByExample = new ArrayList<BCustomer>();
		
		if(org.getNickname()!=null&&!org.getNickname().equals("")){
		createCriteria.andNicknameLike("%"+org.getNickname()+"%");
		
		selectByExample = mapper.selectByExample(example);
		}else {
			selectByExample = mapper.selectByExample(example);
		}
		
		PageInfo<BCustomer> pageInfo = new PageInfo<BCustomer>(selectByExample);
		
		
		
		return pageInfo;
	}
	//通过id查找用户
	@Override
	public BCustomer selectById(Integer id) {
		BCustomer selectByPrimaryKey = mapper.selectByPrimaryKey(id);
		return selectByPrimaryKey;
	}
	
	/**
	 * 保存或更新用户
	 * 
	 */
	@Override
	public boolean saveOrUpdate(BCustomer org) {
		boolean status=false;
		int num=0;
		if(org.getId()!=null){
			num=mapper.updateByPrimaryKeySelective(org);
		}else{
			//获取系统时间
			long l=System.currentTimeMillis();
			Date date=new Date(l);
			SimpleDateFormat d=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = d.format(date);
			org.setRegdate(format);
			org.setPwd(MD5Utils.string2MD5(org.getPwd()));
			num=mapper.insertSelective(org);
		}
		if(num!=0){
			status=true;
		}
		
		return status;
	}
	//根据id修改用户密码
	@Override
	public boolean updatePasswordById(BCustomer bCustomer) {
		boolean status = false;
		
	
		int num = mapper.updatePasswordById(bCustomer);
		if(num>0){
		status = true;
	}
		return status;
	

}
	@Override
	public boolean updatePhoneById(BCustomer bCustomer) {
		boolean bl = false;
		int num = mapper.updateByPrimaryKeySelective(bCustomer);
		if(num>0){
			bl=true;
		}
		return bl;
	}
	@Override
	public int selectcount() {
		
		long countByExample = mapper.countByExample(null);
		int count=(int)countByExample;
		return count;
	}
	@Override
	public int selectcounts() {
		BCustomerExample example=new BCustomerExample();
		Criteria createCriteria = example.createCriteria();
		//获取当日时间
		NowDate nowDate=new NowDate();
		String nowDay = nowDate.nowDay();
		
		createCriteria.andRegdateEqualTo(nowDay);
		long countByExample = mapper.countByExample(example);
		Integer num=(int)countByExample;
		return num;
	}
}
