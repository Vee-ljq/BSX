package com.ry.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ry.dto.BillDto;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrdermain;
import com.ry.service.BillService;

@Controller
@RequestMapping("/webbill")
public class BillController {

	@Autowired
	private BillService BillService;
	
	@RequestMapping("billAll")
	public String billAll(HttpSession session,HttpServletRequest request){
		//获取用户id
		BCustomer customer = (BCustomer)session.getAttribute("customer");
		if(customer==null){
			return "redirect:../web/login.action";
		}
		//查询购买的所有商品
		List<BillDto> bill = BillService.selectAllGoods(customer.getId());
		//查询总消费额
		BillDto sum = BillService.selectSum(customer.getId());
		//查询当月时间
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");

		Calendar c = Calendar.getInstance();

		c.add(Calendar.MONTH, 0);

		c.set(Calendar.DAY_OF_MONTH,1);//1:本月第一天

		String day1= format.format(c.getTime());

		//System.out.println("本月第一天:"+day1);

		//获取当前月最后一天

		Calendar ca = Calendar.getInstance();

		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));

		String day2= format.format(ca.getTime());

		//System.out.println("本月最后一天:"+day2);
		//获取月
		String m = day1.substring(5,7);
		request.setAttribute("m", m);
		request.setAttribute("begin", day1);
		request.setAttribute("last", day2);
		request.setAttribute("sum", sum);
		request.setAttribute("bill", bill);
		return "web/bill";
	}
	
	/**查询账单明细
	 * @param session
	 * @return
	 */
	@RequestMapping("billlist")
	public ModelAndView billlist(Integer date,HttpSession session){
		ModelAndView mav = new ModelAndView("web/billlist");
		//获取用户id
		BCustomer customer = (BCustomer)session.getAttribute("customer");
		Map map = new HashMap();
		map.put("cusid", customer.getId());
		map.put("date", date);
		//查询购买的所有商品
		List<BillDto> bi = BillService.selectGoodsByDate(map);
		mav.addObject("bi", bi);
		mav.addObject("date", date);
		return mav;
		
	}
	
	/**删除
	 * @param bord
	 * @return
	 */
	@ResponseBody
	@RequestMapping("toDelect")
	public boolean toDelect(BOrdermain bord){
		boolean a = BillService.deleteBillList(bord);
			
		return a;
	}
	
	

	
}
