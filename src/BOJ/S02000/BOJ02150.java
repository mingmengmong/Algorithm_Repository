package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ02150 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static boolean[][] E;
	public static boolean[][] RE;
	
	public static boolean[] visit;
	public static Stack<Integer> stack = new Stack<>();
	
	public static void BOJ02150(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		E = new boolean[N+1][N+1];
		RE = new boolean[N+1][N+1];
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			E[n1][n2] = true;
			RE[n2][n1] = true;
		}
		
		visit = new boolean[N+1];
		for(int i=1; i<=N; ++i){
			if(!visit[i]){
				dfs(i);
			}
		}
		
		
		visit = new boolean[N+1];
		PriorityQueue<PriorityQueue<Integer>> pq = new PriorityQueue<PriorityQueue<Integer>>((o1, o2) -> Integer.compare(o1.peek(), o2.peek()));
		
		while(!stack.isEmpty()){
			int n = stack.pop();
			if(!visit[n]){
				PriorityQueue<Integer> iter = new PriorityQueue<>();
				revdfs(n, iter);
				pq.add(iter);
			}
		}
		
		bw.write(String.format("%d\n", pq.size()));
		while(!pq.isEmpty()){
			PriorityQueue<Integer> iter = pq.poll();
			while(!iter.isEmpty()){
				bw.write(String.format("%d ",iter.poll()));
			}
			bw.write("-1\n");
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void dfs(int n){
		if(visit[n]){
			return;
		}
		
		visit[n] = true;
		for(int i=1; i<=N; ++i){
			if(E[n][i] && !visit[i]){
				dfs(i);
			}
		}
		stack.push(n);
	}
	
	public static void revdfs(int n, PriorityQueue<Integer> iter){
		if(visit[n]){
			return;
		}
		
		visit[n] = true;
		for(int i=1; i<=N; ++i){
			if(RE[n][i] && !visit[i]){
				revdfs(i, iter);
			}
		}
		iter.add(n);
	}
}