import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ14226 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static class Node{
		int n, copy;
		public Node(int n, int copy) {
			this.n = n;
			this.copy = copy;
		}
	}
	
	static int S, MAX=1_000;
	static int[][] dp = new int[MAX*2+1][MAX+1];
	static boolean[][] visit = new boolean[MAX*2+1][MAX+1];
	
	public static void BOJ14226(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		S = sc.nextInt();
		for(int i=0; i<=MAX*2; ++i) Arrays.fill(dp[i], 1_000_000);
		dp[1][0] = 0;
		List<Node> list = new LinkedList<>();
		list.add(new Node(1, 0));
		int res = 0;
		while(!list.isEmpty()){
			Node iter = list.remove(0);
			int n = iter.n;
			int copy = iter.copy;
			
			if(n == S){
				res = dp[n][copy];
				break;
			}
			
			if(visit[n][copy]) continue;
			visit[n][copy] = true;
			
			int next = dp[n][copy] + 1;
			
			if(n+copy <= MAX*2 && !visit[n+copy][copy]){
				dp[n+copy][copy] = Math.min(dp[n+copy][copy], next);
				list.add(new Node(n+copy, copy));
			}
			
			if(n-1 > 0 && !visit[n-1][copy]){
				dp[n-1][copy] = Math.min(dp[n-1][copy], next);
				list.add(new Node(n-1, copy));
			}
			
			copy = n;
			if(n <= MAX*2 && copy <= MAX && !visit[n][copy]){
				dp[n][copy] = Math.min(dp[n][copy], next);
				list.add(new Node(n, copy));
			}
		}
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}