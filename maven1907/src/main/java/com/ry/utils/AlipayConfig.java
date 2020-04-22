package com.ry.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2017070707676141";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDc7vELclZak52p\r\n" + 
    		"prqUdq5Ztq4k/JKfrn+gH2OK8nfQdZAccvyShhPkJh186ERQ41b1VONvtZWVt3SR\r\n" + 
    		"t3mYgQ/k9Zx7p2WUHtMQmcgHb67g18FOOzyIEmy1UsM4pAIA19D1I2DPhdwAHnfb\r\n" + 
    		"EGXlXGjp4ZypG3jUrdGOoLGp0UWYJnt+o8ZZef41auYzXvyxPisOvO28CsLl1PJ0\r\n" + 
    		"pyZgsolOo8HGuCbEVNFLF683Bg7nSRhcXzjapaJ1W3jRqDz0mBS0lsj4x5j3KtjY\r\n" + 
    		"LeRyP2QbC5X2F/I9SOziej0yF0J+JKevDWe6MXQAD++lDwC6D4yqrKIhNn+kr5E2\r\n" + 
    		"z/ZeN+sHAgMBAAECggEAR5pJFOShiAl/d5RJtAQizYCfP+17t7TeOA70O/wJSM5R\r\n" + 
    		"Pmcl5Hb/y1lvBSRhv7VuYWR5saKwMC2c4f0Ms5hghlvzsz+1dCPpU+ADLCXOD6Dd\r\n" + 
    		"TXV1UMRn5vxDuP+uhodreYdVwOwpOQCm56CQ5Zzlg6dTFpuItaT/3bHG4rqoS37S\r\n" + 
    		"3BDGqTY0/+yowNQHnquP7m+nujDNkmmbEfdrm+o2tQHJ2XkiZzSB1IpTefrvObyV\r\n" + 
    		"ssmffEdbxHqatieM+kLKp0bSSQx7XQYBgBp65pBAsZPmU4c9vXhP5n3iYf4ahggR\r\n" + 
    		"Tv0tVvWQQn1rMrRdEOIppt3RElF8pOKDhhX/7eTjwQKBgQD91nnsOl9s058tzS7+\r\n" + 
    		"yzE/OZ6orEkgW7ZspVP9zGS+QzFQptHWMtAK+3FbsxhyQ/WQOWalYRiD/fHBxvVa\r\n" + 
    		"wl0M7vXtkOaNUC0u5DRF7ACKN9DYfLefLfCvHVmOoXTwi0iKlAYs5vrRCqhpsjAk\r\n" + 
    		"yvfqizgAxU1DKexiYzkw41HrdQKBgQDe0LaYVnzX449BceSuUW0SFn9K0xnEcPaJ\r\n" + 
    		"uFivDC62tYd5w2Uovft1HH78ZP70CUtwbKU9fed3OYedk8iKbjUvkbxRhiufcugV\r\n" + 
    		"SxeqqTVpJf6S9YAg3SHkHLSVHHCbwgoEuOOZE2U3vKPQk+Z6rXA2464x5MyciQsD\r\n" + 
    		"I+PWHTb5CwKBgQCNKp0NqfztydcJosWS/6+4qLO6vG3CqB6Q13UZfXU9dqLTZqLm\r\n" + 
    		"C8Y1hVaql7Rtv6uudK3IJXJ73Vt418wVmGglTDPK1b3SMxedr13+0NwQAjCMZPe9\r\n" + 
    		"d9AVoy3uK46cQ+mo3997U02DufilJ2qs24/6iUgw7YklZAhJQ0NIE/O4DQKBgQCZ\r\n" + 
    		"pwBkKTBKiIifrvTuKQS4Nn9tkAny55t7+X5eqF4GbUSReWdnIywm5JHFZ7hRfZ9i\r\n" + 
    		"VenVb9+Q3kFhLypaHAndVfixl365pDnbhT861xkX+7WEjnvfLd9TOWBme4hEQRk7\r\n" + 
    		"jGyXgUKJnzKwgW2tJ7F8iKH1kjxvrinD7poNa3QfZQKBgBl4unTmB06COTzFeEhd\r\n" + 
    		"N4fWsTY4VEWg/kXdT4T3f7BUs8mt1Cq6FP+cvX79N62kyXVZayegY+LXS01e7Nw+\r\n" + 
    		"89f+xyILy5fc4iFmC6QuSkbvWMlzQo1tcdrbiKLheRLjC/eU8QryeEGTUx9BHsTt\r\n" + 
    		"FKTF/msnq4XAtwteMuuxGlof";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA3O7xC3JWWpOdqaa6lHau\r\n" + 
    		"WbauJPySn65/oB9jivJ30HWQHHL8koYT5CYdfOhEUONW9VTjb7WVlbd0kbd5mIEP\r\n" + 
    		"5PWce6dllB7TEJnIB2+u4NfBTjs8iBJstVLDOKQCANfQ9SNgz4XcAB532xBl5Vxo\r\n" + 
    		"6eGcqRt41K3RjqCxqdFFmCZ7fqPGWXn+NWrmM178sT4rDrztvArC5dTydKcmYLKJ\r\n" + 
    		"TqPBxrgmxFTRSxevNwYO50kYXF842qWidVt40ag89JgUtJbI+MeY9yrY2C3kcj9k\r\n" + 
    		"GwuV9hfyPUjs4no9MhdCfiSnrw1nujF0AA/vpQ8Aug+MqqyiITZ/pK+RNs/2Xjfr\r\n" + 
    		"BwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

