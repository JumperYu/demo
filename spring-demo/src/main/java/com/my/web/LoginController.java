/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.my.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.my.entity.User;
import com.my.util.Exceptions;

/**
 * LoginController
 * 
 * 示例几种json返回方式
 * 
 * @author zxm
 */
@Controller
public class LoginController {

	private static transient final Logger log = LoggerFactory
			.getLogger(LoginController.class);

	// 寻址 **/login.jsp
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute User user) {

		Subject subject = SecurityUtils.getSubject();

		if (user != null && StringUtils.isNotBlank(user.getUsername())) {
			UsernamePasswordToken token = new UsernamePasswordToken(
					user.getUsername(), user.getPassword());
			subject.login(token);
		}

		/*
		 * try { } catch (AuthenticationException e) {
		 * log.info("Error authenticating.", e); }
		 */
		if (subject.isAuthenticated())
			return "redirect:index";
		else
			return "login";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "{uri}")
	public String getUrl(@PathVariable String uri) {
		return uri;
	}

	// 上传
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String formUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		try {
			InputStream in = file.getInputStream();
			FileOutputStream out = new FileOutputStream("d:/"
					+ file.getOriginalFilename());
			IOUtils.copy(in, out);
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		} catch (IOException e) {
			Exceptions.unchecked(e);
		}
		return "redirect:index";
	}

	// 最简单粗暴 但这种并不能改变content-type为application/json
	@RequestMapping(value = "/name")
	@ResponseBody
	public String getBodyText(@PathVariable String name,
			HttpServletResponse response) {
		// response.setContentType("application/json");
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "{name : \"" + name + "\"}";
	}

	// 最麻烦, 最没用
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView getJsonByView() {
		ModelAndView mav = new ModelAndView("jsonView");
		return mav;
	}

	// 最原始
	@RequestMapping(value = "/resp", method = RequestMethod.GET)
	public void respJson(HttpServletRequest request,
			HttpServletResponse response) {
		// 这里不能用单引号,无效,死的心都有
		String result = "{\"name\":\"哈哈\"}";
		PrintWriter out = null;
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.write(result);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 使用配置的converter-jackson
	@RequestMapping("/mapConvert")
	@ResponseBody
	public Map<Object, Object> mapConvert() {
		Map<Object, Object> modelMap = new HashMap<Object, Object>();
		modelMap.put("NAME", "zxm");
		modelMap.put("aGe", "25");
		return modelMap;
	}

	// 同上
	@RequestMapping("listConvert")
	@ResponseBody
	public List<Object> listConvert() {
		List<Object> modelList = new ArrayList<Object>();
		Object[] arrs = new Object[] { 1, 2, 3, 4, 5 };
		modelList.add(arrs);
		return modelList;
	}

}
