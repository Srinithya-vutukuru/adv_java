package com.sg.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sg.Column;
import com.sg.Table;

public class SQLUtil {
	
	public static String getCreateStatement(Class<?> clazz) {
		
		StringBuilder builder = new StringBuilder();
		
		Table t = clazz.getAnnotation(Table.class);
		
		if (t != null) {
			builder.append("create table ");
			builder.append(t.name());
			builder.append("("); // create table books(
			
			Method[] methods = clazz.getDeclaredMethods();
			
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column c = m.getAnnotation(Column.class);
					if(c != null) {
						builder.append(c.name());
						builder.append(" ");
						builder.append(c.type());
						builder.append(",");
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		
		return builder.toString();
	}
	
	//Book(55,"Java Head First",1200.00)
	//insert into books values(55,'Java Head First',1200.00)
	public static String getInsertSQL(Object object) {
		StringBuilder builder = new StringBuilder();
		
		Table t = object.getClass().getAnnotation(Table.class);
		
		if (t != null) {
			builder.append("inset into ");
			builder.append(t.name());
			builder.append(" values ("); // create table books(
			
			Method[] methods = object.getClass().getDeclaredMethods();
			
			for(Method m : methods) {
				if(m.getName().startsWith("get")) {
					Column c = m.getAnnotation(Column.class);
					if(c != null) {
						try {
							Object ret = m.invoke(object);
							if(ret instanceof String) {
								builder.append("'");
								builder.append(ret);
								builder.append("'");
							}else {
								builder.append(ret);
							}
							builder.append(",");
						}
						catch(IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
						builder.append(c.name());
						builder.append(" ");
						builder.append(c.type());
						builder.append(",");
					}
				}
			}
			builder.setCharAt(builder.lastIndexOf(","), ')');
		}
		
		return builder.toString();
	}
}
