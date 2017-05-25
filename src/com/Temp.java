package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Temp {
	
	public static String getRandomString(int length) {
		Random r = new Random();
		String output = "";
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 5; i++) {
			List<Character> characters = new ArrayList<Character>();
			for (char c : alpha.toCharArray())
				characters.add(c);
			StringBuilder out = new StringBuilder(alpha.length());
			while (characters.size() != 0)
				out.append(characters.remove((int) (Math.random() * characters.size())));
			alpha = out.toString();
		}
		for (int i = 0; i < length; i++)
			output += alpha.charAt(r.nextInt(length));
		return output;
	}
}


