package com.ry.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ry.dto.AddressDto;
import com.ry.dto.BcartGoodsDto;
import com.ry.dto.GoodsDto;
import com.ry.dto.OrdersDto;
import com.ry.pojo.BCustomer;
import com.ry.pojo.BOrderdetail;
import com.ry.service.BcartService;
import com.ry.service.GoodsService;
import com.ry.service.OrdersService;
import com.ry.utils.AlipayConfig;
import com.ry.utils.NowDate;

@Controller
@RequestMapping("/webAlipay")
public class AliPayController {
	
@Autowired
 GoodsService goodService;
@Autowired
OrdersService ordService;
@Autowired
BcartService cartService;

//修改结算页面的数量
@RequestMapping("updateNum")
@ResponseBody
public boolean toUpdateNum(Integer num,Integer cartid){
	boolean status=false;
	int i=cartService.updateNumById(num,cartid);
	if(i>0){
		status=true;
	}
	return status;
	
	
}



@RequestMapping("nowBuy")
public ModelAndView toTjOrder(Integer type, Integer goodsid,Integer cusid,Integer tasteid,String tasname,Integer packageid,String pacname,String num, Integer[] carts,HttpSession session){

	ModelAndView mav=new ModelAndView("web/pay");
	
	if(type!=null){
	
	//购物车结算type为2
	if(type==2){
		List<BcartGoodsDto> cartList=new ArrayList<BcartGoodsDto>();
		double totalPrice=0d;
		//通过购物车的id查询相应信息
	   for(int i=0;i<carts.length;i++){ 
	    BcartGoodsDto cartDto= cartService.selectCartByCartId(carts[i]); 
	    totalPrice+=cartDto.getNum()*Double.parseDouble(cartDto.getBloBs().getPrice());
		cartList.add(cartDto);
	 }
	//查询用户信息
	 BCustomer cus = (BCustomer)session.getAttribute("customer");
	 Integer cusid1=cus.getId();
	

	//查询该用户的地址信息
	List<AddressDto> addrdto=goodService.selectAddrByCusid(cusid1);
		mav.addObject("cartList", cartList);
		mav.addObject("type", type);
		mav.addObject("cus", cus);
		mav.addObject("addrdto", addrdto);
		mav.addObject("totalPrice", totalPrice);
	}}else{
		
		
	//从立即购买跳过来查询商品信息
		//查询用户信息
		BCustomer cus=goodService.selectCust(cusid);
		//查询该用户的地址信息
		List<AddressDto> addrdto=goodService.selectAddrByCusid(cusid);
	GoodsDto goodsdto=goodService.selectGoodsById(goodsid);
	double totalPrice=0d;
	totalPrice=Double.parseDouble(goodsdto.getPrice())*Integer.parseInt(num);
			
	mav.addObject("cus", cus);
	mav.addObject("addrdto", addrdto);
	mav.addObject("goodsdto", goodsdto);
	mav.addObject("goodsid", goodsid);
	mav.addObject("tas", tasteid);
	mav.addObject("tasname",tasname);
	mav.addObject("pac",packageid);
	mav.addObject("pacname",pacname);
	mav.addObject("num", num);
	mav.addObject("totalPrice", totalPrice);
	}
	
	
	return mav;	
}



//支付成功显示订单的详情页
@RequestMapping(value="toSave",produces = "text/html; charset=UTF-8")
@ResponseBody
public String toSaveOrd(Integer type,Integer cusid,Integer goodsid,Integer addressid,HttpServletRequest request,HttpServletResponse response,String num,Integer[] cartIds){
	//请求
		String result=null;
	//获得当前订单主表中最大的id
	int maxid=ordService.selectMaxId();
	//生成订单编号
	String  ordno=NowDate.nowDayOrd()+maxid;		
	//从立即支付跳转的提交订单
	if(type==null){
	//给orderdto赋值
	OrdersDto orddto=new OrdersDto();
	orddto.setCusid(cusid);
	orddto.setAddressid(addressid);
	orddto.setOrderno(ordno);
	orddto.setStatus(0);
	orddto.setCreatedate(NowDate.nowTime());
	BOrderdetail orddet=new BOrderdetail();
	orddet.setGoodsid(goodsid);
	orddet.setMainid(orddto.getId());
	orddet.setNum(num);
	orddto.setOrderdetail1(orddet);
	ordService.insertOrderDto(orddto,1);
    
	//获取到商品id
	
	/*Integer goodsId = orddto.getOrderdetail1().getGoodsid();*/
	//处理购物车的提交订单
	}else{
		List<BcartGoodsDto> cartList=new ArrayList<BcartGoodsDto>();
		List<BOrderdetail> detlist=new ArrayList<BOrderdetail>();
		BOrderdetail det;
		for(int i=0;i<cartIds.length;i++){
			  //将所有购物车商品遍历
			BcartGoodsDto cartDto= cartService.selectCartByCartId(cartIds[i]); 
	        cartList.add(cartDto);
	        //给详情表集合赋值
	        det=new BOrderdetail();
			det.setPrice(cartDto.getBloBs().getPrice());
			det.setNum(cartDto.getNum().toString());
			det.setGoodsid(cartDto.getGoodsid());
			det.setTastedid(cartDto.getTasteid());
			det.setPackageid(cartDto.getPackageid());
			detlist.add(det);
			
		}
		//先插入主表（不插总价)
		OrdersDto orddto=new OrdersDto();
		orddto.setCusid(cusid);
		orddto.setAddressid(addressid);
		orddto.setOrderno(ordno);
		orddto.setCreatedate(NowDate.nowTime());
		orddto.setStatus(0);
		orddto.setOrderdetail(detlist);
		ordService.insertOrderDto(orddto,2);
		
		 
	}
	
	//http://localhost:8080/xxx/toHot/gooodsId.action，必须把返回参数写成http://的形式
	//获得初始化的AlipayClient
	AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, 
	  AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);	
	//设置请求参数
	if(goodsid!=null){
		AlipayConfig.return_url="http://localhost:8080/maven1907/webHot/toHot/"+goodsid+".action";
	}else{
		AlipayConfig.return_url="http://localhost:8080/maven1907/webHome/index.action";
	}
	AlipayConfig.notify_url="http://localhost:8080/maven1907/webAlipay/showOrdDet.action";
	AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	alipayRequest.setReturnUrl(AlipayConfig.return_url);
	alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
	//输出
	PrintWriter ps;
	try {
		//商户订单号，商户网站订单系统中唯一订单号，必填
		String out_trade_no = new String(ordno.getBytes("ISO-8859-1"),"UTF-8");
		//付款金额，必填
		String total_amount = new String("0.01".getBytes("ISO-8859-1"),"UTF-8");
		//订单名称，必填//放中文时需要进行utf-8的编码
		String subject = new String(ordno.getBytes("ISO-8859-1"),"UTF-8");
		//商品描述，可空
		String body = new String("".getBytes("ISO-8859-1"),"UTF-8");	
		alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
				+ "\"total_amount\":\""+ total_amount +"\"," 
				+ "\"subject\":\""+ subject +"\"," 
				+ "\"body\":\""+ body +"\"," 
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");	
		result = alipayClient.pageExecute(alipayRequest).getBody();
//		System.out.println(result);
//		ps = response.getWriter();
//		ps.write(result);
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (AlipayApiException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}
//支付成功显示订单的详情页
@RequestMapping("showOrdDet")
@ResponseBody
public void returnOrdDet(HttpServletRequest request,HttpServletResponse response) throws IOException, AlipayApiException{	
	    PrintWriter out=response.getWriter();
	//获取支付宝POST过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		
		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		
		/* 实际验证过程建议商户务必添加以下校验：
		1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
		3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		4、验证app_id是否为该商户本身。
		*/
		if(signVerified) {//验证成功
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			
			if(trade_status.equals("TRADE_FINISHED")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
					
				//注意：
				//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			}else if (trade_status.equals("TRADE_SUCCESS")){
				//判断该笔订单是否在商户网站中已经做过处理
				//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				//如果有做过处理，不执行商户的业务程序
				
				//注意：
				//付款完成后，支付宝系统发送该交易状态通知
				OrdersDto orddto=new OrdersDto();
				orddto.setOrderno(out_trade_no);
				orddto.setStatus(1);
				orddto.setZfborderno(trade_no);
				ordService.updateOrderMain(orddto);
			}
			out.println("success");
		}else {//验证失败
			out.println("fail");
		
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}
}



//点击设为默认地址
@RequestMapping("updateDefaultAdd")
@ResponseBody
public boolean updateDefaultAdd(Integer defaultid){
	boolean status=false;
	int num=ordService.updateDefaultAdd(defaultid);
	if(num==1){
		status=true;
	}
	return status;
	
}

}
