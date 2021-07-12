package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01918 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;

	public static Map<Character, Integer> priorityMap = new HashMap<>();
	static{
		priorityMap.put('(', 0);
		priorityMap.put('+', 1);
		priorityMap.put('-', 1);
		priorityMap.put('*', 2);
		priorityMap.put('/', 2);
	}
	

	public static void BOJ01918(String[] args) throws Exception {
		char[] str = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int length = str.length;
		for(int i=0; i<length; ++i){
			char c = str[i];
			if(Character.isAlphabetic(c)){
				sb.append(c);
			}else{
				if(c == '('){
					stack.push(c);
				}else if(c == ')'){
					while(stack.peek() != '('){
						sb.append(stack.pop());
					}
					stack.pop();
				}else{
					int p = priorityMap.get(c);
					if(stack.isEmpty()){
						stack.push(c);
					}else if(stack.peek() == '('){
						stack.push(c);
					}else{
						while(!stack.isEmpty() && priorityMap.get(stack.peek()) >= p){
							sb.append(stack.pop());
						}
						stack.push(c);
					}
				}
			}
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		System.out.println(sb);

		sc.close();
		bw.close();
		br.close();
	}
}