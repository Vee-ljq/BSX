package com.ry.utils;

public class NewCode {

	 private static int newcode;
	    public static int getNewcode() {
	        return newcode;
	    }
	    public static String setNewcode(){
	         newcode = (int)(Math.random()*9999)+100;  //每次调用生成一次四位数的随机数
	        String newcode1 = newcode+""; 
	        System.out.println(newcode);
	        return newcode1;
	        
	    }
}
