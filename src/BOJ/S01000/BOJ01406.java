package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BOJ01406 {
	public static void BOJ01406(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		Stack<String> left = new Stack<>();
		Stack<String> right = new Stack<>();
		
		char[] inputStr = br.readLine().toCharArray();
		for(char c : inputStr){
			left.push(c+"");
		}
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; ++tc){
			String[] strSpl = br.readLine().split(" ");
			if("L".equals(strSpl[0])){
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
			}else if("D".equals(strSpl[0])){
				if(!right.isEmpty()){
					left.push(right.pop());
				}
			}else if("B".equals(strSpl[0])){
				if (!left.isEmpty()) {
					left.pop();
				}
			}else{
				left.push(strSpl[1]);
			}
		}
		
		while(!left.isEmpty()){
			right.push(left.pop());
		}
		
		while(!right.isEmpty()){
			sb.append(right.pop());
		}
		
		System.out.println(sb);
		
		sc.close();
		br.close();
	}
}
