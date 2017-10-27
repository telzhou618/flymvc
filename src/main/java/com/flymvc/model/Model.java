package com.flymvc.model;

import java.io.Serializable;

import com.flymvc.db.Db;

public abstract class Model implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 保存
	 * @return
	 */
	public boolean save(){
		return Db.save(this);
	}
}
