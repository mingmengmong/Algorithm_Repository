package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class BOJ01874 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void BOJ01874(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; ++i){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> st = new Stack<>();
		int pivot = 1;
		boolean b = false;
		
		for(int i=0; i<N; ++i){
			int n = arr[i];
			while(pivot <= n){
				st.push(pivot++);
				sb.append("+\n");
			}
			
			if(st.peek() == n){
				st.pop();
				sb.append("-\n");
			}else{
				b = true;
				break;
			}
		}
		
		if(b){
			System.out.println("NO");
		}else{
			System.out.println(sb.toString());
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}