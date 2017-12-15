package com.alliance.model;
import java.util.Date;  		
public class Invoice extends BaseMapperVO {
/**用户角色*/
private String userRole;
/**用户编码*/
private String userCode;
/**历史用户角色*/
private String hisUserRole;
/**历史用户编码*/
private String hisUserCode;
/**发票ID*/
private String invoiceId;
/**发票代码*/
private String invoiceCode;
/**发票号码*/
private String invoiceNum;
/**验证码后六位*/
private String checkCode;
/**开票日期*/
private String invoiceDate;
/**失效日期*/
private String expiryDate;
/**发票类型名称*/
private String invoiceTypeName;
/**价税合计*/
private double totalAmount;
/**机器编码*/
private String deviceCode;
/**密码区*/
private String pswCode;
/**省市地区*/
private String area;
/**购买方名称*/
private String buyerName;
/**购买方纳税人识别号*/
private String buyerCode;
/**购买方地址、电话*/
private String buyerInfo;
/**购买方开户行及账号*/
private String buyerAccount;
/**销售方名称*/
private String supplierName;
/**销售方纳税人识别号*/
private String supplierCode;
/**销售方地址、电话*/
private String supplierInfo;
/**销售方开户行及账号*/
private String supplierAccount;
/**发票备注*/
private String note;
/**发票可用金额*/
private double amountUseable;
/**发票已用金额*/
private double amountPaid;
/**发票使用状态*/
private String isUsed;
/**是否作废*/
private String isCancel;
/**收录方式*/
private String inputWay;
/**创建用户名称*/
private String inputUser;
}
