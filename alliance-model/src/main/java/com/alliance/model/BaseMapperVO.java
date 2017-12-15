package com.alliance.model;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseMapperVO implements Serializable, Cloneable {
	/**
	 * @Description 一句话描述方法用法
	 * @see 需要参考的类或方法
	 * @author guangzhi.ji
	 */
	private static final long serialVersionUID = 8526661484493450718L;
	/** 主键 */
	private String id;
	/** 版本号 */
	private int optimistic;
	/** 创建时间 */
	private Date createTime;



	public BaseMapperVO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOptimistic() {
		return optimistic;
	}

	public void setOptimistic(int optimistic) {
		this.optimistic = optimistic;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}



	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}


}