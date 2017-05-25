package com;

import java.io.IOException;

public class City {

	public static void main(String[] args) {
		ExcelReadExample temp = new ExcelReadExample();
		Temp obj = new Temp();
		try {
			String str = temp.readExcel("E:\\Study\\GitHub\\ReadDataFromExcelFile\\", "Cities.xls", "Data");
			System.out.println(str);
			String arr[] = str.split(";");
			String country[] = new String[arr.length / 2];
			String city[] = new String[arr.length / 2];
			int cnt = 0, ncnt = 0, ccnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (cnt == 0)
					country[ncnt++] = arr[i];
				else
					city[ccnt++] = arr[i];
				cnt++;
				if (cnt == 2)
					cnt = 0;
			}
			int countrymax = country[0].length();
			for (int i = 0; i < country.length; i++) {
				if (countrymax < country[i].length())
					countrymax = country[i].length();
				System.out.println(country[i]);
			}
			int citymax = city[0].length();
			for (int i = 0; i < city.length; i++) {
				if (citymax < city[i].length())
					citymax = city[i].length();
				System.out.println(city[i]);
			}
			System.out.println(countrymax + " << "+citymax);
			String insert = "insert into city(cityId,countryName,cityName) values";
			String query = "";
			for (int i = 0; i < city.length; i++) {
				query += ",('"+obj.getRandomString(15)+"','" + country[i] + "','" + city[i] + "')";
			}
			System.out.println(insert + query.substring(1, query.length()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

/*package com;

import java.io.IOException;

public class City {

	public static void main(String[] args) {
		ExcelReadExample temp = new ExcelReadExample();
		try {
			String str = temp.readExcel("E:\\Study\\GitHub\\ReadDataFromExcelFile\\", "Cities.xls", "Data");
			System.out.println(str);
			String arr[] = str.split(";");
			String country[] = new String[arr.length / 2];
			String city[] = new String[arr.length / 2];
			int cnt = 0, ncnt = 0, ccnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (cnt == 0)
					country[ncnt++] = arr[i];
				else
					city[ccnt++] = arr[i];
				cnt++;
				if (cnt == 2)
					cnt = 0;
			}
			int countrymax = country[0].length();
			for (int i = 0; i < country.length; i++) {
				if (countrymax < country[i].length())
					countrymax = country[i].length();
				System.out.println(country[i]);
			}
			int citymax = city[0].length();
			for (int i = 0; i < city.length; i++) {
				if (citymax < city[i].length())
					citymax = city[i].length();
				System.out.println(city[i]);
			}
			System.out.println(countrymax + " << "+citymax);
			String insert = "";
			String query = "";
			for (int i = 0; i < city.length; i++) {
				String temp1 = "abc'sdf";
				System.out.println(temp1+ " ");
				for (int j = 0; j < temp1.length(); j++) {
					if((temp1.charAt(j)+"").equals("'")){
						System.out.println(temp1.charAt(j)+"");
						System.out.println("ok");
					}
					System.out.println(temp1.charAt(j)+"");
				}
				temp1 = temp1.replaceAll("'", "\'");
				System.out.println(temp1+"<<");
				query += "insert into city(cityId,countryName,cityName) values('CID" + "','" + country[i] + "','" + temp1 + "');";
			}
		//	System.out.println(insert + query.substring(0, query.length()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
*/