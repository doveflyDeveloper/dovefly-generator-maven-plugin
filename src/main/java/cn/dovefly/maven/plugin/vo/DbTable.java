package cn.dovefly.maven.plugin.vo;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DbTable {
	//所有属性字段都是小写
	private String tableName = "";//表名
	private String comment = "";//表备注
	private String author = System.getProperty("user.name", "");
	private String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	private DbColumn keyColumn;//主键列
	private List<DbColumn> columns;//表中所有列

	private Map<String, Pojo> pojos;

	public DbTable(String tableName, String comment, DbColumn keyColumn, List<DbColumn> columns) {
		this.tableName = tableName;
		this.comment = comment;
		this.keyColumn = keyColumn;
		this.columns = columns;
	}

	public void initConfig(GlobalConfig config) {
		this.pojos = new HashMap<>();
		pojos.put("mapper", new Pojo(config.getMapper()));
		pojos.put("entity", new Pojo(config.getEntity()));
		pojos.put("repo", new Pojo(config.getRepo()));
		pojos.put("service", new Pojo(config.getService()));
		pojos.put("serviceImpl", new Pojo(config.getServiceImpl()));
		pojos.put("controller", new Pojo(config.getController()));

	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public DbColumn getKeyColumn() {
		return keyColumn;
	}

	public void setKeyColumn(DbColumn keyColumn) {
		this.keyColumn = keyColumn;
	}

	public List<DbColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<DbColumn> columns) {
		this.columns = columns;
	}

	public Map<String, Pojo> getPojos() {
		return pojos;
	}

	public void setPojos(Map<String, Pojo> pojos) {
		this.pojos = pojos;
	}

	public String getKeyPropertyWithJdbcType() {
		return "#{" + keyColumn.getColumnName() + ", jdbcType=" + keyColumn.getJdbcType() + "}";
	}
//
//	/**
//	 * 功能: 获得Java规范后的类名，例如：t_notice_msg --> TNoticeMsg
//	 *
//	 * @return
//	 */
//	private String getDefaulClassName() {
//		if (tableName == null || tableName.length() == 0) {
//			return "";
//		}
//		String str = "";
//		String[] aName = tableName.split("_");
//		for (int i = 0; i < aName.length; i++) {
//			str += toUpperFirst(aName[i].toLowerCase());
//		}
//		return str;
//	}
	
	/**
	 * 获得主键列以外的所有列
	 * @return
	 */
	public List<DbColumn> getColumnsWithoutKey() {
		if (columns != null && columns.size() > 0) {
			return columns.stream().filter(x -> !x.getColumnName().equals(keyColumn.getColumnName())).collect(Collectors.toList());

		}
		return new ArrayList<>();
	}

//
//	/**
//	 * 功能: 将字符串首字母大写，其余全部变小写
//	 *
//	 * @param str 原字符串
//	 * @return
//	 */
//	private static String toUpperFirst(String str) {
//		if(str == null || str.length() == 0) {
//			return str;
//		} else {
//			return str.substring(0, 1).toUpperCase() + str.substring(1);
//		}
//	}

}
