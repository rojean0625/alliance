package com.alliance.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class CodeMeachinePortal {

	/** 默认生成文件的路径 */
	private String generateMapperXmlPath = "H:/workspace/recon-two/recon-two-portal/src/main/resources/com/pay/recontwo/portal/mapper/";
	private String generateMapperClassPath = "H:/workspace/recon-two/recon-two-portal/src/main/java/com/pay/recontwo/portal/mapper/";
	private String generateDaoClassPath = "H:/workspace/recon-two/recon-two-portal/src/main/java/com/pay/recontwo/portal/dao/";
	private String generateServiceClassPath = "H:/workspace/recon-two/recon-two-portal/src/main/java/com/pay/recontwo/portal/service/";
	private String generateServiceImplClassPath = "H:/workspace/recon-two/recon-two-portal/src/main/java/com/pay/recontwo/portal/service/impl/";
	private String generateControllerClassPath = "H:/workspace/recon-two/recon-two-portal/src/main/java/com/pay/recontwo/portal/web/controller/";
	private String packagePath = "com.pay.recontwo.model";
	private String mapperPath = "com.pay.recontwo.portal.mapper";
	private String mapperXmlModel = "portal/mapperXmlModel.ftl";
	private String mapperClassModel = "portal/mapperClassModel.ftl";
	private String daoClassModel = "portal/daoClassModel.ftl";
	private String serviceClassModel = "portal/serviceClassModel.ftl";
	private String serviceImplClassModel = "portal/serviceImplClassModel.ftl";
	private String controllerClassModel = "portal/controllerClassModel.ftl";
	private String fileWebDir = "H:/workspace/recon-two/recon-two-core/src/main/resources/template/";

	@Resource
	private FreeMakerUtil freeMakerUtil;
	@Resource
	private DataSource dataSource;

	/**
	 * @Description 一句话描述方法用法
	 * @param templateName
	 * @param tableName
	 * @param mapperSimpleName
	 * @param mapperAbsoluteName
	 * @param beanSimpleName
	 * @param beanAbsoluteName
	 * @throws Exception
	 * @see 需要参考的类或方法
	 */
	public void generateMapperXmlFile(String tableName) throws Exception {
		String javaClassName = getClassNameByTableName(tableName);
		String mapperSimpleName = javaClassName + "Mapper";
		String filaName = javaClassName + "Mapper";
		String beanSimpleName = javaClassName;
		List<FieldBean> listFieldBean = findFieldBeans(tableName);
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("mapperSimpleName", mapperSimpleName);
		templateData.put("mapperAbsoluteName", mapperPath + "." + mapperSimpleName);
		templateData.put("beanSimpleName", beanSimpleName);
		templateData.put("beanAbsoluteName", packagePath + "." + beanSimpleName);
		templateData.put("properties", listFieldBean);
		freeMakerUtil.generateFile(mapperXmlModel, templateData, generateMapperXmlPath + filaName + ".xml", fileWebDir);

	}

	/**
	 * @Description 一句话描述方法用法
	 * @param templateName
	 * @param tableName
	 * @param mapperSimpleName
	 * @param mapperAbsoluteName
	 * @param beanSimpleName
	 * @param beanAbsoluteName
	 * @throws Exception
	 * @see 需要参考的类或方法
	 */
	public void generateMapperClassFile(String tableName) throws Exception {
		String javaClassName = getClassNameByTableName(tableName);
		String mapperSimpleName = javaClassName + "Mapper";
		String filaName = javaClassName + "Mapper";
		String beanSimpleName = javaClassName;
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("mapperSimpleName", mapperSimpleName);
		templateData.put("mapperAbsoluteName", mapperPath + "." + mapperSimpleName);
		templateData.put("beanSimpleName", beanSimpleName);
		templateData.put("beanAbsoluteName", packagePath + "." + beanSimpleName);
		freeMakerUtil.generateFile(mapperClassModel, templateData, generateMapperClassPath + filaName + ".java", fileWebDir);

	}

	/**
	 * @Description 一句话描述方法用法
	 * @param templateName
	 * @param tableName
	 * @param mapperSimpleName
	 * @param mapperAbsoluteName
	 * @param beanSimpleName
	 * @param beanAbsoluteName
	 * @throws Exception
	 * @see 需要参考的类或方法
	 */
	public void generateDaoClassFile(String tableName) throws Exception {
		String javaClassName = getClassNameByTableName(tableName);
		String mapperSimpleName = javaClassName + "Mapper";
		String filaName = javaClassName + "Dao";
		String beanSimpleName = javaClassName;
		String annotationName = getLowFirstNameByTableName(tableName) + "Dao";
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("mapperSimpleName", mapperSimpleName);
		templateData.put("mapperAbsoluteName", mapperPath + "." + mapperSimpleName);
		templateData.put("beanSimpleName", beanSimpleName);
		templateData.put("beanAbsoluteName", packagePath + "." + beanSimpleName);
		templateData.put("annotationName", annotationName);
		freeMakerUtil.generateFile(daoClassModel, templateData, generateDaoClassPath + filaName + ".java", fileWebDir);

	}

	/**
	 * @Description 一句话描述方法用法
	 * @param templateName
	 * @param tableName
	 * @param mapperSimpleName
	 * @param mapperAbsoluteName
	 * @param beanSimpleName
	 * @param beanAbsoluteName
	 * @throws Exception
	 * @see 需要参考的类或方法
	 */
	public void generateServiceClassFile(String tableName) throws Exception {
		String javaClassName = getClassNameByTableName(tableName);
		String mapperSimpleName = javaClassName + "Mapper";
		String filaName = javaClassName + "Service";
		String filaNameImpl = javaClassName + "ServiceImpl";
		String beanSimpleName = javaClassName;
		String annotationName = getLowFirstNameByTableName(tableName) + "Service";
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("mapperSimpleName", mapperSimpleName);
		templateData.put("mapperAbsoluteName", mapperPath + "." + mapperSimpleName);
		templateData.put("beanSimpleName", beanSimpleName);
		templateData.put("beanAbsoluteName", packagePath + "." + beanSimpleName);
		templateData.put("annotationName", annotationName);
		freeMakerUtil.generateFile(serviceClassModel, templateData, generateServiceClassPath + filaName + ".java", fileWebDir);
		freeMakerUtil.generateFile(serviceImplClassModel, templateData, generateServiceImplClassPath + filaNameImpl + ".java", fileWebDir);

	}

	/**
	 * @Description 一句话描述方法用法
	 * @param templateName
	 * @param tableName
	 * @param mapperSimpleName
	 * @param mapperAbsoluteName
	 * @param beanSimpleName
	 * @param beanAbsoluteName
	 * @throws Exception
	 * @see 需要参考的类或方法
	 */
	public void generateControllerFile(String tableName) throws Exception {
		String javaClassName = getClassNameByTableName(tableName);
		String mapperSimpleName = javaClassName + "Mapper";
		String filaName = javaClassName + "Controller";
		String beanSimpleName = javaClassName;
		String annotationName = getLowFirstNameByTableName(tableName);
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("mapperSimpleName", mapperSimpleName);
		templateData.put("mapperAbsoluteName", mapperPath + "." + mapperSimpleName);
		templateData.put("beanSimpleName", beanSimpleName);
		templateData.put("beanAbsoluteName", packagePath + "." + beanSimpleName);
		templateData.put("annotationName", annotationName);
		freeMakerUtil.generateFile(controllerClassModel, templateData, generateControllerClassPath + filaName + ".java", fileWebDir);

	}

	/**
	 * @Description 根据表名形成类名
	 * @param tablename
	 * @return
	 * @see 需要参考的类或方法
	 */
	public String getClassNameByTableName(String tablename) {
		String[] split = tablename.split("_");
		StringBuffer sb = new StringBuffer();
		for (String tempS : split) {
			if (tempS == null || "".equals(tempS)) {
				continue;
			}
			sb.append(tempS.substring(0, 1).toUpperCase());
			sb.append(tempS.substring(1));
		}
		return sb.toString();
	}

	/**
	 * @Description 根据表名形成注入类名
	 * @param tablename
	 * @return
	 * @see 需要参考的类或方法
	 */
	public String getLowFirstNameByTableName(String tablename) {
		String[] split = tablename.split("_");
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (String tempS : split) {
			if (tempS == null || "".equals(tempS)) {
				i++;
				continue;
			}
			if (i == 0) {
				sb.append(tempS);
			} else {
				sb.append(tempS.substring(0, 1).toUpperCase());
				sb.append(tempS.substring(1));
			}
			i++;
		}
		return sb.toString();
	}

	/**
	 * @Description mysql根据表名查询字段名
	 * @param tablename
	 * @return
	 * @throws SQLException
	 * @see 需要参考的类或方法
	 */
	private List<FieldBean> findFieldBeans(String tablename) throws SQLException {
		List<FieldBean> list = new ArrayList<FieldBean>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String querySql = execSql(tablename);
			prepareStatement = connection.prepareStatement(querySql);
			rs = prepareStatement.executeQuery(querySql);
			while (rs.next()) {
				String oldfieldname = rs.getString("oldfieldname");
				/** 这三个字段父类继承不需要生成 */
				if ("id".equals(oldfieldname) || "optimistic".equals(oldfieldname) || "create_time".equals(oldfieldname)) {
					continue;
				}
				FieldBean FieldBean = new FieldBean();
				FieldBean.setFieldName(oldfieldname);
				FieldBean.setProName(getFieldNameByTableName(oldfieldname));
				list.add(FieldBean);
			}
		} catch (Exception e) {} finally {
			if (rs != null) {
				rs.close();
			}
			if (prepareStatement != null) {
				prepareStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return list;
	}

	/**
	 * @Description mysql查询表字段、类型、注解的SQL
	 * @param tablename
	 * @return
	 * @see 需要参考的类或方法
	 */
	public String execSql(String tablename) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT 			");
		sb.append("LOWER(column_name)   as oldfieldname ");
		sb.append("FROM           ");
		sb.append("information_schema.columns    ");
		sb.append("WHERE TABLE_NAME = '" + tablename + "'  ");
		return sb.toString();
	}

	/**
	 * @Description 表里字段形成BEAN-FIELD
	 * @param tablename
	 * @return
	 * @see 需要参考的类或方法
	 */
	public String getFieldNameByTableName(String field) {
		String[] split = field.split("_");
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (String tempS : split) {
			if (tempS == null || "".equals(tempS)) {
				continue;
			}
			if (i != 0) {
				sb.append(tempS.substring(0, 1).toUpperCase());
				sb.append(tempS.substring(1));
			} else {
				sb.append(tempS);
			}
			i++;
		}
		return sb.toString();
	}

}
