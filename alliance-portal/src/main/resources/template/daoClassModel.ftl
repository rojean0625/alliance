package com.pay.recontwo.core.dao;

import org.springframework.stereotype.Repository;

import com.alliance.mapper.AbstractBaseMapper;
import ${mapperAbsoluteName};
import ${beanAbsoluteName};


@Repository("${annotationName}")
public class ${beanSimpleName}Dao extends AbstractBaseMapper<${beanSimpleName}> implements ${mapperSimpleName} {
	public ${beanSimpleName}Dao() {
		super(${mapperSimpleName}.class.getName());
	}

}
