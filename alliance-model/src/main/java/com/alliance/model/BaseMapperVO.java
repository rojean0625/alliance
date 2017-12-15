package com.alliance.model;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseMapperVO implements Serializable, Cloneable {
	private static final long serialVersionUID = -5623281485310381361L;
	/** 主键 */
	private String id;
	/** 版本号 */
	private int optimistic;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date modifyTime;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the optimistic
	 */
	public int getOptimistic() {
		return optimistic;
	}

	/**
	 * @param optimistic the optimistic to set
	 */
	public void setOptimistic(int optimistic) {
		this.optimistic = optimistic;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}


}