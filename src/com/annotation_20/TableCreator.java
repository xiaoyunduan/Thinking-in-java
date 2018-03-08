package com.annotation_20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
public class TableCreator {

	public static void main(String[] args) throws ClassNotFoundException {
		if(args.length<0){
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}
		
	    for(String className:args){
	    	Class<?> cn=Class.forName(className);
	    	DBTable dbTable=cn.getAnnotation(DBTable.class);
	    	if(dbTable==null){
	    		System.out.println("NoClassDefFoundError DBTable annotations in class"+className);
	    		continue;
	    	}
	    	
	    	String tableName=dbTable.name();
	    	if(tableName.length()<0){
	    		tableName=cn.getName().toUpperCase();
	    	}
	    	List<String> columnDefs=new ArrayList<String>();
	    	for(Field field: cn.getDeclaredFields()){
	    		String columName=null;
	    		Annotation[] annotations=field.getDeclaredAnnotations();
	    		if(annotations.length<1){
	    			continue;
	    		}
	    		if(annotations[0] instanceof SQLInteger){
	    			SQLInteger sInt=(SQLInteger)annotations[0];
	    			if(sInt.name().length()<1)
	    			columName=field.getName().toUpperCase();
	    			else
	    				columName=sInt.name();
	    			columnDefs.add(columName+"INT"+ getConstraints(sInt.constraints()));
	    		}
	    		
	    		if(annotations[0] instanceof SQLString){
	    			SQLString sString=(SQLString)annotations[0];
	    			if(sString.name().length()<1)
	    				columName=field.getName().toUpperCase();
	    			else
	    				columName=sString.name();
	    			columnDefs.add(columName+ "VARCHAR("+sString.value()+")"+
	    				getConstraints(sString.constraints()));
	    		}
	    		StringBuilder createCommand=new StringBuilder(
	    				"CREATE TABLE"+ tableName+"(");
	    		for(String columDef :columnDefs){
	    			createCommand.append("\n  "+columDef +".");
	    			String tableCreate=createCommand.substring(
	    					0,createCommand.length()-1); //
	    					System.out.println(
	    							"Table Creation SQL for"+ className+ "is :\n"+tableCreate);
	    					
	    		}
	    	}
	    	
	    }
	   
	}
	  private static String getConstraints(Constraints con){
	    	 String constraints="";
	    	 if(!con.allowNull())
	    		 constraints +="NOT NULL";
	    	 if(con.primaryKey())
	    		 constraints +="PRIMARY KEY";
	    	 if(con.unique())
	    		 constraints +="UNIQE";
	    	 return constraints;
	     }
}
