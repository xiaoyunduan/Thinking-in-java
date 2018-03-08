package container_11;

import tool.Print;

public class TestMyStack {
public static void main(String[] args){
	Stack<Character> stack=new Stack<Character>();
	String string="+U+n+c--+e+r+t-+n+y";
	char c[]=string.toCharArray();
	for(int i=0;i<string.length();i++){
		switch(c[i]){
		case '+':stack.push(c[++i]);break;
		case '-':System.out.println(stack.pop());break;
			
		}
	}
System.out.println(stack);
}
}
