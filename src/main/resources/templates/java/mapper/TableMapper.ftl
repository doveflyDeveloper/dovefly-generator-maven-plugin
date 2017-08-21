<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${table.pojos.mapper.fullClassName}Mapper">
    <resultMap id="BaseResultMap" type="${table.pojos.mapper.fullClassName}">
        <constructor>
            <idArg column="${table.keyColumn.columnName}" javaType="${table.keyColumn.javaType}" jdbcType="${table.keyColumn.jdbcType}"/>
            <#list table.columnsWithoutKey as column>
            <arg column="${column.columnName}" javaType="${column.javaType}" jdbcType="${column.jdbcType}"/>
            </#list>
        </constructor>
    </resultMap>

    <sql id="Base_Column_List">
        ${table.keyColumn.columnName}<#list table.columnsWithoutKey as column>, ${column.columnName}</#list>
    </sql>

    <insert id="insert" keyColumn="${table.keyColumn.columnName}" keyProperty="${table.keyColumn.propertyName}" parameterType="${table.pojos.mapper.fullClassName}" useGeneratedKeys="true">
        INSERT INTO ${table.tableName} (
        <#list table.columnsWithoutKey as column>
            ${column.columnName}<#if column_has_next>,</#if>
        </#list>
        ) VALUES (
        <#list table.columnsWithoutKey as column>
            ${column.propertyNameWithJdbcType}<#if column_has_next>,</#if>
        </#list>
        )
    </insert>

    <insert id="insertSelective" keyColumn="${table.keyColumn.columnName}" keyProperty="${table.keyColumn.propertyName}" parameterType="${table.pojos.mapper.fullClassName}" useGeneratedKeys="true">
        INSERT INTO ${table.tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list table.columnsWithoutKey as column>
            <if test="${column.propertyName} != null">
            ${column.columnName}<#if column_has_next>,</#if>
            </if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
        <#list table.columnsWithoutKey as column>
            <if test="${column.propertyName} != null">
            ${column.propertyNameWithJdbcType}<#if column_has_next>,</#if>
            </if>
        </#list>
        </trim>
    </insert>

    <delete id="deleteByPrimaryKey" parameterType="${table.keyColumn.javaType}">
        DELETE FROM ${table.tableName}
        WHERE ${table.keyColumn.columnName} = ${table.keyColumn.propertyNameWithJdbcType}
    </delete>

    <update id="updateByPrimaryKeySelective" parameterType="${table.pojos.mapper.fullClassName}">
        UPDATE ${table.tableName}
        <set>
        <#list table.columnsWithoutKey as column>
            <if test="${column.propertyName} != null">
                ${column.columnName} = ${column.propertyNameWithJdbcType}<#if column_has_next>,</#if>
            </if>
        </#list>
        </set>
        WHERE ${table.keyColumn.columnName} = ${table.keyColumn.propertyNameWithJdbcType}
    </update>

    <update id="updateByPrimaryKey" parameterType="${table.pojos.mapper.fullClassName}">
        UPDATE ${table.tableName}
        SET
        <#list table.columnsWithoutKey as column>
            ${column.columnName} = ${column.propertyNameWithJdbcType}<#if column_has_next>,</#if>
        </#list>
        WHERE ${table.keyColumn.columnName} = ${table.keyColumn.propertyNameWithJdbcType}
    </update>

    <select id="selectByPrimaryKey" parameterType="${table.keyColumn.javaType}" resultMap="BaseResultMap">
        SELECT <include refid="Base_Column_List"/>
        FROM ${table.tableName}
        WHERE ${table.keyColumn.columnName} = ${table.keyColumn.propertyNameWithJdbcType}
    </select>

</mapper>