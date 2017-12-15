package com.alliance.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.pay.commons.utils.Page;
import com.pay.commons.utils.bean.BeanMapUtils;
import com.pay.recontwo.bean.WebResult;
import com.pay.recontwo.inner.api.${beanSimpleName}Interface;
import com.pay.recontwo.model.${beanSimpleName};
import com.pay.recontwo.portal.service.${beanSimpleName}Service;
import com.pay.recontwo.portal.web.bean.${beanSimpleName}Bean;


@Controller
@RequestMapping("{organ}/${annotationName}")
public class ${beanSimpleName}Controller {

	private Logger logger = LoggerFactory.getLogger(${beanSimpleName}Controller.class);

	@Resource
	private ${beanSimpleName}Interface ${annotationName}Interface;
	@Resource
	private ${beanSimpleName}Service ${annotationName}Service;

	/**
	 * @Description 查跳转页面
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("to${beanSimpleName}Query")
	public ModelAndView to${beanSimpleName}Query() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/${annotationName}/${annotationName}Query");
		return model;
	}

	/**
	 * @Description 查询结果
	 * @param request
	 * @param ${annotationName}Bean
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("${annotationName}Query")
	public ModelAndView ${annotationName}Query(HttpServletRequest request,
			@ModelAttribute("${annotationName}Bean") ${beanSimpleName}Bean ${annotationName}Bean) {
		ModelAndView model = new ModelAndView();
		// 当前页
		int currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
		// 分页实体
		Page<List<${beanSimpleName}>> page = new Page<List<${beanSimpleName}>>();
		page.setCurrentPage(currentPage);
		Map<String, Object> transBeanToMap = BeanMapUtils.transBeanToMap(${annotationName}Bean, false);
		List<${beanSimpleName}> list = ${annotationName}Service.findAllByMap(page, transBeanToMap);
		model.addObject("page", page);
		model.addObject("list", list);
		model.setViewName("/${annotationName}/${annotationName}QueryResult");
		return model;
	}

	/**
	 * @Description 新增页面跳转
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("to${beanSimpleName}Add")
	public ModelAndView to${beanSimpleName}Add() {
		ModelAndView model = new ModelAndView();
		model.setViewName("/${annotationName}/${annotationName}Add");
		return model;
	}

	/**
	 * @Description 新增业务类型
	 * @param request
	 * @param bean
	 * @param response
	 * @return
	 * @see 需要参考的类或方法
	 */

	@RequestMapping("${annotationName}Add")
	public String ${annotationName}Add(HttpServletRequest request, ${beanSimpleName} bean, HttpServletResponse response) {
		WebResult webResult = new WebResult();
		try {
			int insert = ${annotationName}Interface.insert(bean);
			logger.info("###insert-row:" + insert);
		} catch (Exception e) {
			webResult.setResult("FAIL");
			webResult.setErrorMsg(e.getMessage());
		}
		return JSONUtils.toJSONString(webResult);
	}

	/**
	 * @Description 修改页面跳转
	 * @param request
	 * @param bean
	 * @return
	 * @see 需要参考的类或方法
	 */
	@RequestMapping("to${beanSimpleName}Update")
	public ModelAndView to${beanSimpleName}Update(HttpServletRequest request, ${beanSimpleName} ${annotationName}) {
		ModelAndView model = new ModelAndView();
		model.addObject("${annotationName}", ${annotationName});
		model.setViewName("/${annotationName}/${annotationName}Update");
		return model;
	}

	/**
	 * @Description 修改业务类型
	 * @param request
	 * @param bean
	 * @param response
	 * @see 需要参考的类或方法
	 */

	@RequestMapping("${annotationName}Update")
	public String ${annotationName}Update(HttpServletRequest request, ${beanSimpleName} bean, HttpServletResponse response) {
		WebResult webResult = new WebResult();
		try {
			int updateById = ${annotationName}Interface.updateById(bean);
			logger.info("###update-row:" + updateById);
		} catch (Exception e) {
			webResult.setResult("FAIL");
			webResult.setErrorMsg(e.getMessage());
		}
		return JSONUtils.toJSONString(webResult);
	}

	@RequestMapping("${annotationName}Del")
	public String ${annotationName}Del(String id) {
		WebResult webResult = new WebResult();
		try {
			int delById = ${annotationName}Interface.delById(id);
			logger.info("###delete-row:" + delById);
		} catch (Exception e) {
			webResult.setResult("FAIL");
			webResult.setErrorMsg(e.getMessage());
		}
		return JSONUtils.toJSONString(webResult);
	}

}


