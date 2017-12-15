/**
 *
 */
package com.alliance.utils;

import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: ParamValidator 此处填写需要参考的类
 * @version 2017年12月13日 上午9:34:58
 * @author chao.luo
 */
@Component
public class ParamValidator {
	private static Logger log = LoggerFactory.getLogger(ParamValidator.class);

	@Resource
	private Validator validator;

	public void valid(Object obj) throws Exception {

		if (obj == null) {
			throw new Exception("param is null!");
		}

		Set<ConstraintViolation<Object>> violations = validator.validate(obj); // 参数校验
		if (violations.size() > 0) {
			log.error(obj.getClass() + " param error ");
			ConstraintViolation<Object> v = violations.iterator().next();
			log.error(v.getPropertyPath() + "=" + v.getInvalidValue() + ":" + v.getMessage());
			throw new Exception("param error,deail:" + v.getPropertyPath() + "=" + v.getInvalidValue() + ":" + v.getMessage());
		}
	}
}
