package com.ry.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ry.pojo.BCustomer;
import com.ry.service.IndexWebService;
import com.ry.utils.LhPage;
/**
 * 后台客户列表，详细信息
 * @author WZM
 *
 */
@Controller
@RequestMapping("cust")
public class CustomerController {
	@Autowired
	private IndexWebService service;
	/**
	 * 模糊查询带分页
	 * @param org
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("data")
	public ModelAndView data(BCustomer org,@RequestParam(required=true,defaultValue="1")Integer pageNum,@RequestParam(required=true,defaultValue="2")Integer pageSize){
		ModelAndView mav=new ModelAndView("customer/data");
		/*List<BCustomer> selectCustomerAll = service.selectCustomerAll();
		mav.addObject("customers", selectCustomerAll);*/
		//分页带模糊查询
		PageInfo<BCustomer> selectByPage = service.selectByPage(org,pageNum,pageSize);
		
		LhPage page=new LhPage(selectByPage);
		
		
		mav.addObject("page", page);
		mav.addObject("org", org);
		
		return mav;
	}
	/**
	 * 修改或增加用户
	 * 
	 * @param org
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(BCustomer org){
		ModelAndView mav=new ModelAndView("customer/edit2");
		if(org!=null&&org.getId()!=null){
			org = service.selectById(org.getId());
		}
		mav.addObject("org", org);
		
		
		return mav;
	}
	/**
	 * 点击保存
	 * 进行用户信息提交
	 * @return
	 */
	@RequestMapping("save")
	public String save(BCustomer org,HttpSession session){
		boolean savaOrUpdate=service.saveOrUpdate(org);
		session.setAttribute("org", org);
		
		return "redirect:data.action";
	}
	//webloader单文件上传	
	@RequestMapping("/file")
	@ResponseBody
	public Map toShow(MultipartFile file,HttpServletRequest request) throws IOException{
			    String originalFilename = file.getOriginalFilename();
				String path=request.getRealPath("/");
				String uuId=UUID.randomUUID().toString();
				String newFilename=uuId+originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
				path=path+"/upload/"+newFilename;//d:apache/tomcat<img src="">
				
				file.transferTo(new File(path));
			    Map  map=new HashMap();
			    map.put("id", uuId);
			    map.put("name", newFilename);
				return map;
			}
	

}
