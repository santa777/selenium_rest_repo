package com.practice.PracticeAttempt2;

public class Str1 {
	public static void main(String args[])	{
		StringBuilder str1 = new StringBuilder("Santappa");
		str1.reverse();
		System.out.println(str1);
		StringBuilder str2 = new StringBuilder();
		for(int i = str1.length()-1; i >= 0; i--)
			str2.append(str1.charAt(i));
		str1 = str2;
		System.out.println("String implementation");
		String string1 =  "appatnaS";
		char[] string2 = string1.toCharArray();
		for(int i = string1.length()-1; i >= 0; i --)
			System.out.print(string2[i] = string1.charAt(i));
		
	}

}
