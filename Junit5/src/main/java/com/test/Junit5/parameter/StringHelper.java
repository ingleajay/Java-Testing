package com.test.Junit5.parameter;

import java.util.Stack;

public class StringHelper {

	public static String reverse(String str) {
		if(str == null) {
			return null;
		}
		
		if("".equals(str)) {
			return "";
		}
		char[] reverseString = new char[str.length()];
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        int i = 0;
        while (!stack.isEmpty()) {
            reverseString[i++] = stack.pop();
        }
        return new String(reverseString);
	}
}
