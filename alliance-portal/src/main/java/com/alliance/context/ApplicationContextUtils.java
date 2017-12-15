/**
 *
 */
package com.alliance.context;

import org.springframework.context.ApplicationContext;

/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: AllicationContextUtils 此处填写需要参考的类
 * @version 2017年2月15日 上午11:32:27
 * @author chao.luo
 */
public class ApplicationContextUtils {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(
			ApplicationContext applicationContext) {
		ApplicationContextUtils.applicationContext = applicationContext;
	}
}