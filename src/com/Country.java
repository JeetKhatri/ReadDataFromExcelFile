package com;

import java.io.IOException;

public class Country {

	public static void main(String[] args) {
		ExcelReadExample temp = new ExcelReadExample();
		try {
			String str = temp.readExcel("e:\\", "Countries.xls", "Sheet1");
			System.out.println(str);
			String arr[] = str.split(";");
			String name[] = new String[arr.length/2];
			String code[] = new String[arr.length/2];
			int cnt=0,ncnt=0,ccnt=0;
			for (int i = 0; i < arr.length; i++) {
				if(cnt==0)
					name[ncnt++] = arr[i];
				else
					code[ccnt++] = arr[i];
				cnt++;
				if(cnt==2)cnt=0;
			}
			for (int i = 0; i < name.length; i++) {
				System.out.println(name[i]);
			}
			int max = code[0].length();
			for (int i = 0; i < code.length; i++) {
				
				if(max < code[i].length()) max = code[i].length();
				
				if(code[i].contains(".")){
					code[i] = code[i].substring(0, code[i].length()-2);
					System.out.println("contails : "+code[i]);
				}else
					System.out.println(code[i]);
			}
			String insert="insert into country(countryId,countryName,countryCode) values";
			String query="";
			for (int i = 0; i < code.length; i++) {
				query+=",('CID"+i+"','"+name[i]+"','"+code[i]+"')";
			}
			System.out.println(insert+query.substring(1,query.length()));
			System.out.println(max+"<<");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
