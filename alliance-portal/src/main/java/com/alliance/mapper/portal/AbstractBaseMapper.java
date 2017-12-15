/**
 *
 */
package com.alliance.mapper.portal;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alliance.model.BaseMapperVO;
import com.alliance.utils.Page;


/**
 * @Description: 这里用一句话描述这个类的作用
 * @see: AbstractBaseMapper 此处填写需要参考的类
 * @version 2017年12月13日 下午3:34:55
 * @author chao.luo
 */
public class AbstractBaseMapper<T extends BaseMapperVO> extends SqlSessionDaoSupport implements BaseMapper<T> {
	protected Logger log = LoggerFactory.getLogger(getClass());
	/** mapper注入类名 */
	protected String mapperClassName;

	public AbstractBaseMapper(String mapperClassName) {
		this.mapperClassName = mapperClassName;
	}

	@Override
	public T findById(String id) {
		try {
			String nameSpaceMethod = mapperClassName + ".findById";
			return getSqlSession().selectOne(nameSpaceMethod, id);
		} catch (Exception e) {
			String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
			String method = Thread.currentThread().getStackTrace()[1].getMethodName();
			log.error(clazz + "." + method + "-errorMsg:" + e.getMessage());
		}
		return null;
	}

	@Override
	public List<T> findAllByMap(Page<List<T>> page, Map<String, Object> map) {
		try {
			if (page != null) {
				map.put("page", page);
			}
			String nameSpaceMethod = mapperClassName + ".findAllByMap";
			return getSqlSession().selectList(nameSpaceMethod, map);
		} catch (Exception e) {
			String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
			String method = Thread.currentThread().getStackTrace()[1].getMethodName();
			log.error(clazz + "." + method + "-errorMsg:" + e.getMessage());
		}
		return null;
	}

	@Override
	public List<T> findBySum(Map<String, Object> map) {
		try {
			String nameSpaceMethod = mapperClassName + ".findBySum";
			return getSqlSession().selectList(nameSpaceMethod, map);
		} catch (Exception e) {
			String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
			String method = Thread.currentThread().getStackTrace()[1].getMethodName();
			log.error(clazz + "." + method + "-errorMsg:" + e.getMessage());
		}
		return null;
	}

	@Autowired
	public void setMyBatisSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		setSqlSessionFactory(sqlSessionFactory);
	}

	public String getMapperClassName() {
		return mapperClassName;
	}

	public void setMapperClassName(String mapperClassName) {
		this.mapperClassName = mapperClassName;
	}
}
