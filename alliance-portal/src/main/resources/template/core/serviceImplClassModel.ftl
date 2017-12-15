package com.pay.invoice.core.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import com.pay.invoice.core.dao.${beanSimpleName}Dao;
import com.pay.invoice.core.service.${beanSimpleName}Service;
import com.pay.invoice.model.${beanSimpleName};


@Service("${annotationName}")
public class ${beanSimpleName}ServiceImpl implements ${beanSimpleName}Service {
	@Resource
	private ${beanSimpleName}Dao ${lowerBeanSimpleName}Dao;

	@Override
	public int insert(${beanSimpleName} t) {
		return ${lowerBeanSimpleName}Dao.insert(t);
	}

	@Override
	public int insertList(List<${beanSimpleName}> list) {
		return ${lowerBeanSimpleName}Dao.insertList(list);
	}

	@Override
	public void batchInsert(List<${beanSimpleName}> listModel) {
		${lowerBeanSimpleName}Dao.batchInsert(listModel);
	}

	@Override
	public int delById(String id) {
		return ${lowerBeanSimpleName}Dao.delById(id);
	}

	@Override
	public ${beanSimpleName} findById(String id) {
		return ${lowerBeanSimpleName}Dao.findById(id);
	}

	@Override
	public int updateById(${beanSimpleName} t) {
		return ${lowerBeanSimpleName}Dao.updateById(t);
	}

	@Override
	public int delByMap(Map<String, Object> map) {
		return ${lowerBeanSimpleName}Dao.delByMap(map);
	}

	@Override
	public List<${beanSimpleName}> findByMap(Map<String, Object> map) {
		return ${lowerBeanSimpleName}Dao.findByMap(map);
	}
}
