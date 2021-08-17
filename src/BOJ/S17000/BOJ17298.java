package BOJ.S17000;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX = 1_000_000;
	static int[] arr = new int[MAX+1], res = new int[MAX+1];
	
	public static void BOJ17298(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stk = new Stack<>();
		for(int i=N-1; i>=0; --i){
			while( !stk.isEmpty() && stk.peek() <= arr[i]){
				stk.pop();
			}
			
			if(stk.isEmpty()){
				res[i] = -1;
			}else{
				res[i] = stk.peek();
			}
			
			stk.push(arr[i]);
		}
		
		for(int i=0; i<N; ++i){
			bw.write(res[i] + " ");
		}
		bw.newLine();
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}