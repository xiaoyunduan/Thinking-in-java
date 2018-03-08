package com.annotation_20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import tool.Print;




public class PassworduUtils {

	@UseCase(id=47,description="Password must contains at least one numeric")
	public boolean validatePassword(String password){
		return (password.matches("\\w*\\d\\w*"));
	}
	

	@UseCase(id=48)
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id=49,description="New password can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prevPasswords,String password){
		return !prevPasswords.contains(password);
	}
	public static void main(String[] args) {
		PassworduUtils passworduUtils=new PassworduUtils();
		List<String> strList=new ArrayList<String>();
		strList.add("xiaoyunduan");
		strList.add("xiaoyunta");
		Print.print(passworduUtils.validatePassword("xiaoyunduan"));
		Print.print(passworduUtils.encryptPassword("xiaoyunduan"));
		Print.print(passworduUtils.checkForNewPassword(
				strList, "xiaoyunduan"));
	}
}
