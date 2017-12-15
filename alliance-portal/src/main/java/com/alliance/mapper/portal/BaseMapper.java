
package com.alliance.mapper.portal;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.alliance.model.BaseMapperVO;
import com.alliance.utils.Page;


/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: BaseMapper 此处填写需要参考的类
 * @version 2017年12月13日 下午12:06:47
 * @author chao.luo
 */
public interface BaseMapper<T extends BaseMapperVO> {
	/**
	 * @Description 根据Id删除查找
	 * @param id
	 * @return
	 * @see 需要参考的类或方法
	 */
	public abstract T findById(String id);

	/**
	 * @Description 动态参数查找
	 * @param map
	 * @return
	 * @see 需要参考的类或方法
	 */
	public abstract List<T> findAllByMap(@Param("page") Page<List<T>> page, Map<String, Object> map);

	/**
	 * @Description 动态参数查找
	 * @param map
	 * @return
	 * @see 需要参考的类或方法
	 */
	public abstract List<T> findBySum(Map<String, Object> map);
}
