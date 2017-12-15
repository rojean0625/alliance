/**
 *
 */
package com.alliance.utils;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//import com.pay.idgenerator.api.IDGeneratorInterface;

/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: PrimaryKeyGenerator 此处填写需要参考的类
 * @version 2017年12月13日 上午9:30:43
 * @author chao.luo
 */
@Component
public class PrimaryKeyGenerator {

	//@Resource
	//private IDGeneratorInterface idGeneratorInterface;

	public String generateId(Class<?> clazz) {
		String wantIdRule = "invoice" + "." + clazz.getSimpleName() + ".id";
//		idGeneratorInterface.getNewID(wantIdRule);
		return null;
	}

	public String shareId() {
		String wantIdRule = "invoice" + ".Enjoy.id";
//		idGeneratorInterface.getNewID(wantIdRule);
		return null;
	}

	public String getUUID() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);
	}
}
