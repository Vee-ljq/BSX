package com.ry.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowDate {
  //获取当日日期，用于查询今日新增订单
    public static String nowDay() {
    	
    	Date now =new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String nowday=sdf.format(now);
		return nowday;
	}
    //获取当前月份，用于商品详情页的月销量查询
    public static String thisMonth(){
    	Date now =new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
    	String  nowMonth=sdf.format(now);
    	return nowMonth;
    }
    //获取今日日期，用于组成订单编号
 public static String nowDayOrd() {
    	
    	Date now =new Date();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String nowday=sdf.format(now);
		return nowday;
	}
 
 //生成订单生成日期
 public static String nowTime(){
	 Date now =new Date();
 	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String nowday=sdf.format(now);
		return nowday;
 }
}
