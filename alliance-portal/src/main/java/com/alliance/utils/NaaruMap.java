package com.alliance.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class NaaruMap {

	public static Map<String,String> getNaaruMapping(){
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("model", null);
		map.put("xml", "mapperXmlModel.ftl");
		map.put("xmlClass", "mapperClassModel.ftl");
		map.put("dao", "daoClassModel.ftl");
		map.put("daoImpl", "daoImplClassModel.ftl");
		map.put("service", "serviceClassModel.ftl");
		map.put("serviceImpl", "serviceImplClassModel.ftl");
		return map;
	}
}
