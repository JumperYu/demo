package com.my.test.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestEmpty {
	
	private static Logger log = LoggerFactory.getLogger(TestEmpty.class);
	
	@Test
	public void testIsEmpty(){
		String emptyStr1 = "";
		String emptyStr2 = " ";
		String emptyStr3 = " 1 ";
		String emptyStr4 = "123 ";
		String emptyStr5 = "1 2 3";
		String emptyStr6 = "1";
		log.info("is empty: " + StringUtils.isEmpty(emptyStr1));
		log.info("is empty: " + StringUtils.isEmpty(emptyStr2));
		log.info("is empty: " + StringUtils.isEmpty(emptyStr3));
		log.info("is empty: " + StringUtils.isEmpty(emptyStr4));
		log.info("is empty: " + StringUtils.isEmpty(emptyStr5));
		log.info("is empty: " + StringUtils.isEmpty(emptyStr6));
	}
	
	@Test
	public void testIsBlank(){
		String emptyStr1 = "";
		String emptyStr2 = " ";
		String emptyStr3 = " 1 ";
		String emptyStr4 = "123 ";
		String emptyStr5 = "1 2 3";
		String emptyStr6 = "1";
		log.info("is empty: " + StringUtils.isBlank(emptyStr1));
		log.info("is empty: " + StringUtils.isBlank(emptyStr2));
		log.info("is empty: " + StringUtils.isBlank(emptyStr3));
		log.info("is empty: " + StringUtils.isBlank(emptyStr4));
		log.info("is empty: " + StringUtils.isBlank(emptyStr5));
		log.info("is empty: " + StringUtils.isBlank(emptyStr6));
	}
}
