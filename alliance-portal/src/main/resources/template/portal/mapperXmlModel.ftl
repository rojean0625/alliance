<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${mapperAbsoluteName}">
	<resultMap id="${beanSimpleName}" type="${beanAbsoluteName}">
		<id column="id" property="id" />
		<result column="optimistic" property="optimistic" />
		<#list properties as pro>
			<result column="${pro.fieldName}" property="${pro.proName}" />
		</#list>
		<result column="create_time" property="createTime" />
	</resultMap>
	<sql id="commonColumn">
		id,
		optimistic,
		<#list properties as pro>
		${pro.fieldName},
		</#list>
		create_time
	</sql>
	<select id="findById"  resultMap="${beanSimpleName}" parameterType="java.lang.String">
		select <include refid="commonColumn"/> from ${tableName}  where 1=1
			and id=${r"#{id}"}
	</select>
	<select id="findAllByMap"  resultMap="${beanSimpleName}" parameterType="java.util.Map">
		select <include refid="commonColumn"/> from ${tableName}  where 1=1
			<if test="id != null and id != ''">
			and id=${r"#{id}"}
			</if>
			<if test="optimistic != null and optimistic != ''">
			and optimistic=${r"#{optimistic}"}
			</if>
			<#list properties as pro>
				<if test="${pro.proName} != null and ${pro.proName} != ''">
					and ${pro.fieldName}=${r"#{"}${pro.proName}${r"}"}
				</if>
			</#list>
			<if test="createTime != null and createTime != ''">
			and create_time=${r"#{createTime}"}
			</if>
			order by create_time
	</select>
	<select id="findBySum"  resultMap="${beanSimpleName}" parameterType="java.util.Map">
		select <include refid="commonColumn"/> from ${tableName}  where 1=1
			<if test="id != null and id != ''">
			and id=${r"#{id}"}
			</if>
			<if test="optimistic != null and optimistic != ''">
			and optimistic=${r"#{optimistic}"}
			</if>
			<#list properties as pro>
				<if test="${pro.proName} != null and ${pro.proName} != ''">
					and ${pro.fieldName}=${r"#{"}${pro.proName}${r"}"}
				</if>
			</#list>
			<if test="createTime != null and createTime != ''">
			and create_time=${r"#{createTime}"}
			</if>
	</select>
</mapper>