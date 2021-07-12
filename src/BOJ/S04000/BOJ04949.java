package BOJ.S04000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BOJ04949 {
	public static void BOJ04949(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		while(true){
			char[] str = br.readLine().toCharArray();
			if(str[0] == '.' && str.length == 1){
				break;
			}
			
			Stack<Character> stack = new Stack<>();
			boolean b = true;
			for(char c : str){
				if(c == '(' || c == '[' || c == '{'){
					stack.push(c);
				}else if(c == ')'){
					if (stack.isEmpty() || stack.pop() != '(') {
						b = false;
						break;
					}
				}else if(c == ']'){
					if (stack.isEmpty() || stack.pop() != '[') {
						b = false;
						break;
					}
				}else if(c == '}'){
					if (stack.isEmpty() || stack.pop() != '{') {
						b = false;
						break;
					}
				}
			}
			
			if(!stack.isEmpty()){
				b = false;
			}
			
			System.out.println(b?"yes":"no");
		}
		
		sc.close();
		br.close();
	}
}
