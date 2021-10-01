import java.io.*;
import java.util.*;

public class BOJ04803 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M;
	static List<Integer>[] G;
	static boolean[] visit;
	
	static boolean dfs(int u, int par){
		if(visit[u]) return true;
		visit[u] = true;
		
		boolean res = false;
		for(int v : G[u]){
			if(v == par) continue;
			res |= dfs(v, u);
		}
		return res;
	}
	
	public static void BOJ04803 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		for(int TC=1; true; ++TC){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			
			int cnt = 0;
			visit = new boolean[N+1];
			G = new List[N+1];
			for(int i=0; i<=N; ++i) G[i] = new ArrayList<>();
			
			for(int i=0; i<M; ++i){
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				G[u].add(v);
				G[v].add(u);
			}
			
			for(int i=1; i<=N; ++i){
				if(!visit[i]){
					boolean res = dfs(i, 0);
					cnt += res ? 0 : 1;
				}
			}
			
			if(cnt == 0){
				bw.write(String.format("Case %d: No trees.\n", TC));
			}else if(cnt == 1){
				bw.write(String.format("Case %d: There is one tree.\n", TC));
			}else{
				bw.write(String.format("Case %d: A forest of %d trees.\n", TC, cnt));
			}
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}