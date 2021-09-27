import java.io.*;
import java.util.*;

public class BOJ01240 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAX=1_000, head = 1;
	static int[] par = new int[MAX+1], depth = new int[MAX+1];
	static long[] cost = new long[MAX+1];
	static List<int[]>[] G;
	static{
		G = new List[MAX+1];
		for(int i=0; i<=MAX; ++i)
			G[i] = new ArrayList<>();
	}
	
	static void init(int u, int parent){
		par[u] = parent;
		depth[u] = depth[parent] + 1;
		for(int[] iter : G[u]){
			int v = iter[0];
			if(v == parent) continue;
			cost[v] = iter[1] + cost[u];
			init(v, u);
		}
	}
	
	public static void BOJ01240 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			G[u].add(new int[]{v, cost});
			G[v].add(new int[]{u, cost});
		}
		
		init(1, 0);
		
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			long res = cost[u] + cost[v];
			
			while(depth[u] > depth[v]){
				u = par[u];
			}
			
			while(depth[u] < depth[v]){
				v = par[v];
			}
			
			while(u != v){
				u = par[u];
				v = par[v];
			}
			
			res -= 2 * cost[u];
			System.out.println(res);
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}