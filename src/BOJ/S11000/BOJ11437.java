package BOJ.S11000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11437 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int[] depth;
	public static int[] parent;
	public static List<Integer>[] edge;
	
	public static void BOJ11437(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input2")));
		
		N = Integer.parseInt(br.readLine());
		edge = new List[N+1];
		for(int i=1; i<=N; ++i){
			edge[i] = new ArrayList<>();
		}
		
		for(int i=1; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			edge[n1].add(n2);
			edge[n2].add(n1);
		}
		
		depth = new int[N+1];
		parent = new int[N+1];
		dfs(1, 1);
		
		int M = Integer.parseInt(br.readLine());
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			System.out.println(ancestor(n1, n2));
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void dfs(int idx, int cnt){
		depth[idx] = cnt;
		++cnt;
		for(int next : edge[idx]){
			if(depth[next] == 0){
				parent[next] = idx;
				dfs(next, cnt);
			}
		}
	}
	
	public static int ancestor(int n1, int n2){
		if(n1 == n2 && n1 != 0){
			return n1;
		}
		while(depth[n1] != depth[n2] || parent[n1] != parent[n2]){
			if(depth[n1] < depth[n2]){
				n2 = parent[n2];
			}else if(depth[n1] > depth[n2]){
				n1 = parent[n1];
			}else{
				n1 = parent[n1];
				n2 = parent[n2];
			}
		}
		
		if(n1 == n2){
			return n1;
		}else{
			return parent[n1];
		}
	}
}