package com.flymvc.db;

/**
 * 数据表
 * @author jameszhou
 *
 */
public class TTable {

	private String tableName;
	
	private String idName;
	
	private TColumn[] columns;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public TColumn[] getColumns() {
		return columns;
	}

	public void setColumns(TColumn[] columns) {
		this.columns = columns;
	}

	public TTable() {
	}

	public TTable(String tableName) {
		this.tableName = tableName;
	}
}
