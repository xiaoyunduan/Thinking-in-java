package com.OUT_IN_System_18;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import tool.Print;
/*Preferences(��-ֵ����,�洢��һ���ڵ���)��������л���������־��Ը�����,������ԶС��,���޵����ݼ���(�������ݺ��ַ���)*/
public class PreferencesDemo {

	public static void main(String[] args) throws Exception {
		//���������ڵ�洢Preferencess����
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
