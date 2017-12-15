/**
 *
 */
package com.alliance.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: MysqlToBean 此处填写需要参考的类
 * @version 2017年12月12日 下午2:13:36
 * @author chao.luo
 */
@Component
public class MysqlToBean {
	private static Logger log = LoggerFactory.getLogger(MysqlToBean.class);
	@Resource
	private DataSource dataSource;

	private String projectSrcPaht = "H:/workspace/invoice-services/invoice-services-model/src/main/java/com/pay/invoice/model";
	private String packageName = "com.pay.invoice.model";

	private String beanProjectSrcPaht = "H:/workspace/invoice-services/invoice-services-portal/src/main/java/com/pay/invoice/portal/web/bean";
	private String beanPackageName = "com.pay.invoice.portal.web.bean";

	// @Resource
	// private GenFileFormService genFileFormService;

	public void createJavaBean(String tableName) {
		try {
			if (tableName == null || tableName.equals("")) {

			}
			createJavaBeanByTable(projectSrcPaht, packageName, tableName.trim());
			log.info("# createJavaBean - {}", tableName);
		} catch (SQLException e) {
			log.error("##################### ERROR " + e.getMessage());
		}
	}

	public void createWebBean(String tableName) {
		try {
			if (tableName == null || tableName.equals("")) {

			}
			createWebBeanByTable(beanProjectSrcPaht, beanPackageName, tableName.trim());
			log.info("# createWebBean - {}", tableName);
		} catch (SQLException e) {
			log.error("##################### ERROR " + e.getMessage());
		}
	}

	public void testSum() {
		testJavaBean();
		// testWebBean();
	}

	public void testJavaBean() {
		/** 如果不关闭连接 限制了一次执行10个 */
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set", "bank_busi_clear_min", "bank_chargeback_sum_shen" };, "bank_recovery"
		String[] tablenames = new String[] { "invoice" };
		try {
			for (String tempTableName : tablenames) {
				if (tempTableName == null || tempTableName.equals("")) {
					continue;
				}
				createJavaBeanByTable(projectSrcPaht, packageName, tempTableName.trim());
				System.out.println("###################### 1");
			}
		} catch (SQLException e) {
			log.error("##################### ERROR " + e.getMessage());
		}
	}

	public void testWebBean() {
		/** 如果不关闭连接 限制了一次执行10个 */
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set", "bank_busi_clear_min", "bank_chargeback_sum_shen" };
		String[] tablenames = new String[] { "sys_bank_clear_diff" };
		try {
			for (String tempTableName : tablenames) {
				if (tempTableName == null || tempTableName.equals("")) {
					continue;
				}
				createWebBeanByTable(beanProjectSrcPaht, beanPackageName, tempTableName.trim());
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * @Description 根据表名生成JAVABEAN
	 * @param tablename
	 * @throws SQLException
	 * @see 需要参考的类或方法
	 */
	public void createJavaBeanByTable(String filePath, String packagePath, String tablename) throws SQLException {
		String javaClassName = getClassNameByTableName(tablename);
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String querySql = execJavaBeanSql(tablename);
			prepareStatement = connection.prepareStatement(querySql);
			rs = prepareStatement.executeQuery(querySql);
			StringBuffer sb = new StringBuffer();
			sb.append(getClassHead(packagePath, javaClassName));
			while (rs.next()) {
				String fieldcomment = rs.getString("fieldcomment");
				String data_type = rs.getString("data_type");
				String fieldname = rs.getString("fieldname");
				String oldfieldname = rs.getString("oldfieldname");
				/** 这三个字段父类继承不需要生成 */
				if ("id".equals(oldfieldname) || "optimistic".equals(oldfieldname) || "create_time".equals(oldfieldname) || "modify_time".equals(oldfieldname)) {
					continue;
				}
				sb.append(fieldcomment);
				sb.append("\r\n");
				sb.append(data_type);
				sb.append(getFieldNameByTableName(fieldname));
				sb.append("\r\n");
			}
			sb.append("}\r\n");
			writeToTxt(filePath, sb.toString(), javaClassName);
		} catch (Exception e) {

		} finally {
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
	}

	/**
	 * @Description 根据表名生成JAVABEAN
	 * @param tablename
	 * @throws SQLException
	 * @see 需要参考的类或方法
	 */
	public void createWebBeanByTable(String filePath, String packagePath, String tablename) throws SQLException {
		String javaClassName = getClassNameByTableName(tablename);
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			String querySql = execWebBeanSql(tablename);
			prepareStatement = connection.prepareStatement(querySql);
			rs = prepareStatement.executeQuery(querySql);
			StringBuffer sb = new StringBuffer();
			String fileName = javaClassName + "Bean";
			sb.append(getClassHead(packagePath, fileName));
			while (rs.next()) {
				String fieldcomment = rs.getString("fieldcomment");
				String data_type = rs.getString("data_type");
				String fieldname = rs.getString("fieldname");
				String oldfieldname = rs.getString("oldfieldname");
				/** 这三个字段父类继承不需要生成 */
				if ("id".equals(oldfieldname) || "optimistic".equals(oldfieldname) || "create_time".equals(oldfieldname) || "modify_time".equals(oldfieldname)) {
					continue;
				}
				sb.append(fieldcomment);
				sb.append("\r\n");
				sb.append(data_type);
				sb.append(getFieldNameByTableName(fieldname));
				sb.append("\r\n");
			}
			sb.append("}\r\n");
			writeToTxt(filePath, sb.toString(), fileName);
		} catch (Exception e) {

		} finally {
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
	}

	/**
	 * @Description mysql查询表字段、类型、注解的SQL
	 * @param tablename
	 * @return
	 * @see 需要参考的类或方法
	 */
	public String execJavaBeanSql(String tablename) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT 																							\r\n");
		sb.append("CONCAT('/**',COLUMN_COMMENT,'*/') as fieldcomment, --  注解                                        						       		\r\n");
		sb.append("(                                              -- 根据表定义的字段生成相应的 Java类型         		  	 \r\n");
		sb.append("CASE                                                                                             \r\n");
		sb.append("data_type                                                                                        \r\n");
		sb.append("WHEN 'varchar'                                                                                   \r\n");
		sb.append("THEN 'private String'                                                                            \r\n");
		sb.append("WHEN 'numeric'                                                                                   \r\n");
		sb.append("THEN 'private double'                                                                            \r\n");
		sb.append("WHEN 'decimal'                                                                                   \r\n");
		sb.append("THEN 'private double'                                                                            \r\n");
		sb.append("WHEN 'char'                                                                                      \r\n");
		sb.append("THEN 'private String'                                                                            \r\n");
		sb.append("WHEN 'bigint'                                                                                    \r\n");
		sb.append("THEN 'private Integer'                                                                          \r\n ");
		sb.append("WHEN 'int'                                                                                      \r\n ");
		sb.append("THEN 'private int'                                                                           \r\n");
		sb.append("WHEN 'date'                                                                                      \r\n");
		sb.append("THEN 'private Date'                                                                              \r\n");
		sb.append("WHEN 'datetime'                                                                                  \r\n");
		sb.append("THEN 'private Date'                                                                              \r\n");
		sb.append("ELSE 'NULL'                                                                                      \r\n");
		sb.append("END                                                                                             \r\n ");
		sb.append(") AS data_type,                                                                                 \r\n ");
		sb.append("CONCAT(' ',LOWER(column_name),';')    as fieldname, --  字段名                                            \r\n  ");
		sb.append("LOWER(column_name)   as oldfieldname --  原始字段名                                             \r\n  ");
		sb.append("FROM                                                                                           \r\n  ");
		sb.append("information_schema.columns                                                                     \r\n  ");
		sb.append("WHERE TABLE_NAME = '" + tablename + "' ;                                                            \r\n ");
		return sb.toString();
	}

	/**
	 * @Description mysql查询表字段、类型、注解的SQL
	 * @param tablename
	 * @return
	 * @see 需要参考的类或方法
	 */
	public String execWebBeanSql(String tablename) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT 																							\r\n");
		sb.append("CONCAT('/**',COLUMN_COMMENT,'*/') as fieldcomment, --  注解                                        						       		\r\n");
		sb.append("(                                              -- 根据表定义的字段生成相应的 Java类型         		  	 \r\n");
		sb.append("CASE                                                                                             \r\n");
		sb.append("data_type                                                                                        \r\n");
		sb.append("WHEN 'varchar'                                                                                   \r\n");
		sb.append("THEN 'private String'                                                                            \r\n");
		sb.append("WHEN 'numeric'                                                                                   \r\n");
		sb.append("THEN 'private Double'                                                                            \r\n");
		sb.append("WHEN 'decimal'                                                                                   \r\n");
		sb.append("THEN 'private Double'                                                                            \r\n");
		sb.append("WHEN 'char'                                                                                      \r\n");
		sb.append("THEN 'private String'                                                                            \r\n");
		sb.append("WHEN 'bigint'                                                                                    \r\n");
		sb.append("THEN 'private Integer'                                                                          \r\n ");
		sb.append("WHEN 'int'                                                                                      \r\n ");
		sb.append("THEN 'private Integer'                                                                           \r\n");
		sb.append("WHEN 'date'                                                                                      \r\n");
		sb.append("THEN 'private Date'                                                                              \r\n");
		sb.append("WHEN 'datetime'                                                                                  \r\n");
		sb.append("THEN 'private Date'                                                                              \r\n");
		sb.append("ELSE 'NULL'                                                                                      \r\n");
		sb.append("END                                                                                             \r\n ");
		sb.append(") AS data_type,                                                                                 \r\n ");
		sb.append("CONCAT(' ',LOWER(column_name),';')    as fieldname, --  字段名                                            \r\n  ");
		sb.append("LOWER(column_name)   as oldfieldname --  原始字段名                                             \r\n  ");
		sb.append("FROM                                                                                           \r\n  ");
		sb.append("information_schema.columns                                                                     \r\n  ");
		sb.append("WHERE TABLE_NAME = '" + tablename + "' ;                                                            \r\n ");
		return sb.toString();
	}

	public String execGenFormSql(String tablename) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT ");
		sb.append("COLUMN_COMMENT AS simplecomment, ");
		sb.append("LOWER(column_name) AS simplefieldname  ");
		sb.append("FROM ");
		sb.append("information_schema. COLUMNS ");
		sb.append("WHERE ");
		sb.append("TABLE_NAME = '" + tablename + "'; ");
		return sb.toString();
	}

	/**
	 * @Description 生成TXT文件 默认路径和文件后缀
	 * @param sdata
	 * @param filename
	 * @see 需要参考的类或方法
	 */
	public void writeToTxt(String filePath, String sdata, String filename) {
		FileOutputStream outSTr = null;
		BufferedOutputStream Buff = null;
		String path = filePath + "/" + filename + ".java";
		try {
			outSTr = new FileOutputStream(new File(path));
			Buff = new BufferedOutputStream(outSTr);
			Buff.write(sdata.getBytes());
			Buff.flush();
			Buff.close();
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			try {
				Buff.close();
				outSTr.close();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
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

	/**
	 * @Description 获取类的标头
	 * @param javaClassName
	 * @return
	 * @see 需要参考的类或方法
	 */
	public String getClassHead(String packagePath, String javaClassName) {
		StringBuffer sb = new StringBuffer();
		sb.append("package " + packagePath + ";\r\n");
		sb.append("import java.util.Date;  		\r\n");
		sb.append("import com.pay.invoice.model.BaseMapperVO; \r\n");
		sb.append("public class " + javaClassName + " extends BaseMapperVO {\r\n");
		return sb.toString();
	}
}
