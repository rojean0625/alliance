package com.pay.invoice.portal.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import com.pay.commons.utils.Page;
import com.pay.invoice.portal.dao.${beanSimpleName}Dao;
import com.pay.invoice.portal.service.${beanSimpleName}Service;
import com.pay.invoice.model.${beanSimpleName};


@Service("${annotationName}")
public class ${beanSimpleName}ServiceImpl implements ${beanSimpleName}Service {
	@Resource
	private ${beanSimpleName}Dao ${lowerBeanSimpleName}Dao;

	@Override
	public ${beanSimpleName} findById(String id) {
		return ${lowerBeanSimpleName}Dao.findById(id);
	}

	@Override
	public List<${beanSimpleName}> findAllByMap(Page<List<${beanSimpleName}>> page, Map<String, Object> map) {
		return ${lowerBeanSimpleName}Dao.findAllByMap(page, map);
	}

	@Override
	public List<${beanSimpleName}> findBySum(Map<String, Object> map) {
		return ${lowerBeanSimpleName}Dao.findBySum(map);
	}
}
