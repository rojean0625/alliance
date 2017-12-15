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
	<insert id="insert" parameterType="${beanAbsoluteName}">
		insert into ${tableName} (
		<include refid="commonColumn"/>
		)
		values
			(
			${r"#{id}"},
			${r"#{optimistic}"},
			<#list properties as pro>
		   	 ${r"#{"}${pro.proName}${r"}"},
			</#list>
			${r"#{createTime}"}
			)
	</insert>
	<insert id="insertList" parameterType="java.util.List">
		insert into ${tableName} (
		<include refid="commonColumn"/>)
		values
		<foreach collection="list" item="item" index="index" separator="," >
			(
			${r"#{item.id}"},
			${r"#{item.optimistic}"},
			<#list properties as pro>
		   	 ${r"#{"}item.${pro.proName}${r"}"},
			</#list>
			${r"#{item.createTime}"}
			)
		</foreach>
	</insert>
	<delete id="delById" parameterType="java.lang.String">
		delete from ${tableName}
		where id=${r"#{id}"}
	</delete>
	<delete id="delByMap" parameterType="java.util.Map">
		delete from ${tableName}
		where 1=1
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
	</delete>
	<select id="findById"  resultMap="${beanSimpleName}" parameterType="java.lang.String">
		select <include refid="commonColumn"/> from ${tableName}  where 1=1
			and id=${r"#{id}"}
	</select>
    <select id="findByMap"  resultMap="${beanSimpleName}" parameterType="java.util.Map">
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
	<update id="updateById" parameterType="${beanAbsoluteName}">
 		update ${tableName}
			<set>
				id=${r"#{id}"},
				optimistic=${r"#{optimistic}"}+1,
				<#list properties as pro>
					${pro.fieldName}=${r"#{"}${pro.proName}${r"}"},
				</#list>
				create_time=${r"#{"}createTime${r"}"}
			</set>
		WHERE id=${r"#{id}"} and optimistic=${r"#{optimistic}"}
	</update>
</mapper>