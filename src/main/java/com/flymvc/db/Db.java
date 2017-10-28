package com.flymvc.db;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.flymvc.annotation.Column;
import com.flymvc.annotation.Id;
import com.flymvc.annotation.Ignore;
import com.flymvc.annotation.NotNull;
import com.flymvc.annotation.Table;
import com.flymvc.model.Model;

/**
 * 操作model
 * @author jameszhou
 *
 */
public class Db {

	private static Logger logger = Logger.getLogger(Logger.class);
	
	public static boolean save(Model model) {
		// TODO Auto-generated method stub
		
		TTable ttable = parseModel2Table(model);
		List<Object> values = new ArrayList<Object>();
		StringBuffer sqlBuffer = new StringBuffer("insert into ");
			sqlBuffer.append(ttable.getTableName());
			sqlBuffer.append(" (");
			for(TColumn tColumn : ttable.getColumns()){
				sqlBuffer.append(tColumn.getName()).append(",");
				values.add(tColumn.getValue());
			}
			sqlBuffer.deleteCharAt(sqlBuffer.length()-1);
			sqlBuffer.append(" )");
			logger.debug(sqlBuffer.toString()+" values " + values);
			return SqlDb.insert(sqlBuffer.toString(), values.toArray()) > 0;
	}

	
	/**
	 * 解析模型
	 * @param model
	 * @return
	 */
	private static TTable parseModel2Table(Model model) {
		// TODO Auto-generated method stub
		
		TTable ttable = new TTable(model.getClass().getSimpleName().toLowerCase());
		
		Class<?> clazz = model.getClass();
		Table tableAnno  = clazz.getAnnotation(Table.class);
		if(tableAnno != null && StringUtils.isNotBlank(tableAnno.value())){
			ttable.setTableName(tableAnno.value());
		}
		List<TColumn> tcolumns = new ArrayList<TColumn>();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			if(field.getAnnotation(Ignore.class) ==null){
				Id id = field.getDeclaredAnnotation(Id.class);
				if(id != null){
					ttable.setIdName(field.getName());
				}
				
				try {
					
					TColumn tcolumn  = new TColumn();
					Column column = field.getAnnotation(Column.class);
					if(column != null && StringUtils.isNotBlank(column.value())){
						tcolumn.setName(column.value());
					}else{
						tcolumn.setName(field.getName());
					}
					tcolumn.setValue(BeanUtils.getProperty(model, field.getName()));
					tcolumn.setType(field.getType());
					
					NotNull notNull = field.getAnnotation(NotNull.class);
					if(notNull != null){
						tcolumn.setNotNull(true);
					}
					tcolumns.add(tcolumn);
				} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ttable.setColumns(tcolumns.toArray(new TColumn[]{}));
		return ttable;
	}
}
