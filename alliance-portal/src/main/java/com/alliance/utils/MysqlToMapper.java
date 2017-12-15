package com.alliance.utils;
import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: STxtCf 此处填写需要参考的类
 * @version 2014年8月11日 下午2:36:47
 * @author guangzhi.ji
 */
@Component
public class MysqlToMapper {
	private static Logger log = LoggerFactory.getLogger(MysqlToMapper.class);
	@Resource
	private CodeMeachine codeMeachine;
	@Resource
	private CodeMeachinePortal codeMeachinePortal;


	public void testSum() throws Exception {
		testGenerateMapperXmlFile();
		testGenerateMapperXmlFilePortal();
		testGenerateMapperClassFile();
		testGenerateMapperClassFileCore();
		testGenerateDaoClassFile();
		testGenerateDaoClassFileCore();
		testGenerateServiceClassFile();
		testGenerateServiceClassFileCore();
		testGenerateInterfaceClassFile();
		testGenerateControllerClassFile();
	}


	public void testPrem() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set", "bank_busi_clear_min", "bank_chargeback_sum_shen" };
		String[] tablenames = new String[] { "invoice" };
		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachine.printPermissions(tempTableName.trim());
		}
		log.info("testPrem success");
	}


	public void testGenerateMapperXmlFile() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };, "bank_recovery"
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachine.generateMapperXmlFile(tempTableName.trim());
		}
		log.info("testGenerateMapperXmlFile success");
	}


	public void testGenerateMapperXmlFilePortal() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };, "bank_recovery"
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachinePortal.generateMapperXmlFile(tempTableName.trim());
		}
		log.info("testGenerateMapperXmlFile success");
	}


	public void testGenerateMapperClassFile() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachinePortal.generateMapperClassFile(tempTableName.trim());
		}
		log.info("testGenerateMapperClassFile success");
	}


	public void testGenerateMapperClassFileCore() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachine.generateMapperClassFile(tempTableName.trim());
		}
		log.info("testGenerateMapperClassFile success");
	}


	public void testGenerateDaoClassFile() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachinePortal.generateDaoClassFile(tempTableName.trim());
		}
		log.info("testGenerateDaoClassFile success");
	}


	public void testGenerateDaoClassFileCore() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachine.generateDaoClassFile(tempTableName.trim());
		}
		log.info("testGenerateDaoClassFile success");
	}


	public void testGenerateServiceClassFile() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachinePortal.generateServiceClassFile(tempTableName.trim());
		}
		log.info("testGenerateServiceClassFile success");
	}


	public void testGenerateServiceClassFileCore() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachine.generateServiceClassFile(tempTableName.trim());
		}
		log.info("testGenerateServiceClassFile success");
	}


	public void testGenerateInterfaceClassFile() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };

		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachine.generateInterfaceClassFile(tempTableName.trim());
		}
		log.info("testGenerateInterfaceClassFile success");
	}


	public void testGenerateControllerClassFile() throws Exception {
		// String[] tablenames = new String[] { "bank_chargeback_detail", "bank_clear_notice", "bank_fund_clear", "bank_order", "bank_trans_sum", "busi_ass_set",
		// "busi_check_log", "busi_check_result", "busi_trans_charge", "clear_file_cond", "down_file_set", "file_down_log", "file_parse_log", "file_parse_set",
		// "file_templet_set", "gen_file_form", "luo_file_parse_set", "msg_file_form", "notice_team", "notice_team_b", "remote_ftp_set", "sys_order",
		// "union_inst_set" };
		String[] tablenames = new String[] { "invoice" };
		for (String tempTableName : tablenames) {
			if (tempTableName == null || tempTableName.equals("")) {
				continue;
			}
			codeMeachinePortal.generateControllerFile(tempTableName.trim());
		}
		log.info("testGenerateControllerClassFile success");
	}
}
