package com.OUT_IN_System_18;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import tool.Print;
/*Preferences(键-值集合,存储于一个节点中)与对象序列化相比与对象持久性更密切,不过永远小的,受限的数据集合(基本数据和字符串)*/
public class PreferencesDemo {

	public static void main(String[] args) throws Exception {
		//创建类名节点存储Preferencess集合
		Preferences prefs=Preferences.userNodeForPackage(PreferencesDemo.class);
		prefs.put("a", "b");
		prefs.put("c", "d");
		prefs.putInt("i", 8);
		prefs.putBoolean("are you s", true);
		int usageCount=prefs.getInt("UsageCount", 0);
		usageCount++;
		prefs.putInt("UsageCount", usageCount);
		for(String key:prefs.keys()){
			Print.println(key+":"+prefs.get(key, null));
		}
		
	}
}
