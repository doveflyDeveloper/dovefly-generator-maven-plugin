package cn.dovefly.maven.plugin.vo;

public class DbColumn {
	// 所有属性字段都是小写
	private String columnName = "";// 数据库字段名
	private String propertyName = "";// java对象属性名
	private String jdbcType = "";// 字段数据库类型
	private String javaType = "";// 对象属性java类型
	private String javaTypeShort = "";// 对象属性java类型
	private Integer length = 0;//字段长度
	private Boolean nullable = true;// 是否可为空
	private String defaultValue = "";//字段默认值
	private String comment = "";//字段备注

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getPropertyName() {
		if (propertyName == null || propertyName.length() == 0) {
			return getDefaultPropertyName();
		}
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaTypeShort() {
		if (javaType == null || javaType.length() == 0) {
			return "";
		}
		return javaType.substring(javaType.lastIndexOf(".") + 1);
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Boolean getNullable() {
		return nullable;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getPropertyNameWithJdbcType() {
		return "#{" + this.getPropertyName() + ", jdbcType=" + jdbcType + "}";
	}

	private String getDefaultPropertyName() {
		if (columnName == null || columnName.length() == 0) {
			return "";
		}
		String str = "";
		String[] aName = columnName.split("_");
		for (int i = 0; i < aName.length; i++) {
			str += toUpperFirst(aName[i].toLowerCase());
		}
		return toLowerFirst(str);
	}

	/**
	 * 功能: 将字符串首字母大写，其余全部变小写
	 *
	 * @param str 原字符串
	 * @return
	 */
	private static String toUpperFirst(String str) {
		if(str == null || str.length() == 0) {
			return str;
		} else {
			return str.substring(0,1).toUpperCase() + str.substring(1);
		}
	}

	private static String toLowerFirst(String str) {
		if(str == null || str.length() == 0) {
			return str;
		} else {
			return str.substring(0,1).toLowerCase() + str.substring(1);
		}
	}

}
