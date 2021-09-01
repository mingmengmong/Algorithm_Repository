package BOJ.S03000;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ03015 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAXN=500_000;
	static Node[] arr = new Node[MAXN+1];
	static class Node{
		int h,cnt;
		public Node(int h, int cnt) {
			this.h = h;
			this.cnt = cnt;
		}
		public String toString(){
			return String.format("(%d, %d)",h,cnt);
		}
	}
	
	public static void BOJ03015(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			arr[i] = new Node(
					Integer.parseInt(br.readLine()), 1
			);
		}
		
		Stack<Node> stk = new Stack<>();
		long res = 0;
		int idx = 0;
		while(idx < N){
			if(stk.isEmpty()){
				stk.push(arr[idx++]);
			}else{
				if(stk.peek().h > arr[idx].h){
					stk.push(arr[idx++]);
					++res;
				}else if(stk.peek().h == arr[idx].h){
					arr[idx].cnt += stk.peek().cnt;
					res += stk.pop().cnt;
				}else{
					res += stk.pop().cnt;
				}
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}