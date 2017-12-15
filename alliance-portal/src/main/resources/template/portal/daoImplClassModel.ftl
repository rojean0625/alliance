package com.pay.invoice.portal.dao.impl;

import org.springframework.stereotype.Repository;

import com.pay.invoice.portal.mapper.AbstractBaseMapper;
import com.pay.invoice.portal.dao.${beanSimpleName}Dao;
import ${mapperAbsoluteName};
import ${beanAbsoluteName};


@Repository("${annotationName}")
public class ${beanSimpleName}DaoImpl extends AbstractBaseMapper<${beanSimpleName}> implements ${beanSimpleName}Dao {
	public ${beanSimpleName}DaoImpl() {
		super(${mapperSimpleName}.class.getName());
	}

}
