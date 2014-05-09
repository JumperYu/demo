package com.my.test.md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD5 {
	
	@Test
	public void testMD5(){
		String str = "app_id=1814810&buy_amount=10&cp_order_id=mt_meizu_7337605_1398766447_1&create_time=1398766520051&notify_id=1398766589010&notify_time=2014-04-29 18:16:29&order_id=14042900000000044&partner_id=0&pay_time=1398766589036&product_id=pid_meizu_7337605_1398766447_1&product_per_price=0.1&product_unit=gold&total_price=1.0&trade_status=3";
		str += (":" + "eSikRwObIpkg9Bmt3ty1R8CJf4nlE5bL");
		System.out.println(DigestUtils.md5Hex(str));
	}
	
	@Test
	public void testStr(){
		String str ="mt_meizu_123_456";
		String str2 = str.substring("mt_meizu_".length());
		System.out.println(str2.substring(0, str2.indexOf("_")));
	}
	
}
