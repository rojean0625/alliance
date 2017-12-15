package com.alliance.mapper;

import java.util.List;
import java.util.Map;


/**
 * @Description: mybatis操作基类接口
 * @see: BaseMapper 此处填写需要参考的类
 * @version 2016年10月12日 下午7:41:12
 * @author guangzhi.ji
 */
public abstract interface BaseMapper<T extends BaseMapperVO> {
	/**
	 * @Description 插入单条数据
	 * @param t
	 * @see 需要参考的类或方法
	 */
	public abstract int insert(T t);

	/**
	 * @Description 插入单条数据
	 * @param t
	 * @see 需要参考的类或方法
	 */
	public abstract int insertList(List<T> list);

	/**
	 * @Description 分批插入
	 * @param t
	 * @see 需要参考的类或方法
	 */
	public abstract void batchInsert(List<T> listModel);

	/**
	 * @Description 根据Id删除
	 * @param id
	 * @see 需要参考的类或方法
	 */

	public abstract int delById(String id);

	/**
	 * @Description 根据Id删除
	 * @param id
	 * @see 需要参考的类或方法
	 */

	public abstract int delByMap(Map<String, Object> map);

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
	public abstract List<T> findByMap(Map<String, Object> map);

	/**
	 * @Description 动态参数修改
	 * @param map
	 * @see 需要参考的类或方法
	 */
	public abstract int updateById(T t);

	/**
	 * @Description 删除历史数据
	 * @param map
	 * @see 需要参考的类或方法
	 */
	public abstract void delHistoryData(Map<String, Object> map);

}
