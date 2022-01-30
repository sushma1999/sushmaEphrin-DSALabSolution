package com.greatlearning.mentoredLabSession3;


import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {

		
	 public static void main(String[] args)
	    {
			Scanner scan = new Scanner(System.in);
	        String input = scan.next();
	 
	        if (isBalanced(input))
	            System.out.println("The entered String has Balanced Brackets");
	        else
	            System.out.println("The entered String do not contain Balanced Brackets");
	    }

	public static boolean isBalanced(String input) {

		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<input.length();i++)
		{
			char ch = input.charAt(i);
			if(ch=='{'|| ch=='['|| ch=='(')
			{
				stack.push(ch);
				continue;
			}
			
			if(stack.isEmpty())
				return false;
			char c;
			switch(ch) {
			case'}' :
				c= stack.pop();
				if(c!='{')
					return false;
				break;
			case']' :
				c= stack.pop();
				if(c!='[')
					return false;
				break;
			case')' :
				c= stack.pop();
				if(c!='(')
					return false;
				break;
			}
		}
		

	
		return (stack.isEmpty());
	}
	
	}

