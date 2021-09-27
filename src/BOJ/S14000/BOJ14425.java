import java.io.*;
import java.util.*;

public class BOJ14425 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static class Node{
//		char c;
		boolean isFinish;
		Node[] next;
		
		public Node() {
//			this.c = c;
			this.isFinish = false;
			this.next = new Node[26];
		}
		
		public void insert(String str, int idx){
			if(str.length() == idx){
				this.isFinish = true;
				return;
			}
			
			int nextIdx = str.charAt(idx) - 'a';
			if(next[nextIdx] == null) next[nextIdx] = new Node();
			
			next[nextIdx].insert(str, idx+1);
		}
		
		public boolean find(String str, int idx){
			if(str.length() == idx){
				return this.isFinish;
			}
			
			int nextIdx = str.charAt(idx) - 'a';
			if(next[nextIdx] == null) return false;
			
			return next[nextIdx].find(str, idx+1);
		}
	}
	
	static Node head = new Node();
	
	public static void BOJ14425(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; ++i){
			String str = br.readLine();
			head.insert(str, 0);
		}
		
		int res = 0;
		for(int i=0; i<M; ++i){
			String str = br.readLine();
			res += head.find(str, 0) ? 1 : 0;
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}