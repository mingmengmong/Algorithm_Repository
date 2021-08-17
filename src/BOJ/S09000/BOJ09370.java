package BOJ.S09000;
import java.io.*;
import java.util.*;

public class BOJ09370 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int TC;
	static int V,E,GC, S,SG,SH;
	static List<Integer>[] G;
	static int[][] C;
	static Set<Integer> SSet, GSet;
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>((ar1,ar2)-> {
//		if(ar1[2] == ar2[2]) return Integer.compare(ar1[1], ar2[1]);
//		return Integer.compare(ar2[2], ar1[2]);
		
//		if(ar1[1] == ar2[1]) return Integer.compare(ar2[2], ar1[2]);
//		return Integer.compare(ar1[1], ar2[1]);
		
		return Integer.compare(ar1[1], ar2[1]);
	});
	
	static void init(){
		G = new List[V+1];
		for(int i=0; i<=V; ++i) G[i] = new ArrayList<>();
		C = new int[V+1][V+1];
		SSet = new HashSet<>();
		SSet.add(SG*V+SH); SSet.add(SH*V+SG);
		GSet = new HashSet<>();
		pq.clear();
	}
	
	public static void BOJ09370(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			GC = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken())-1;
			SG = Integer.parseInt(st.nextToken())-1;
			SH = Integer.parseInt(st.nextToken())-1;
			
			init();
			
			for(int i=0; i<E; ++i){
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken())-1;
				int e = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken()) << 1;
				G[s].add(e);
				G[e].add(s);
				if(SSet.contains(s*V+e)) --c;
				C[s][e] = C[e][s] = c;
			}
			
			for(int i=0; i<GC; ++i){
				GSet.add(Integer.parseInt(br.readLine()) - 1);
			}
			
			// END init
			
			pq.add(new int[]{S,0});
			boolean[] visit = new boolean[V+1];
			int[] length = new int[V+1];
			Arrays.fill(length, Integer.MAX_VALUE-1);
			
			while(!pq.isEmpty()){
				int[] top = pq.poll();
				int u = top[0];
				int cost = top[1];
//				int isGo = top[2];
				
				if(visit[u]) continue;
				visit[u] = true;
				length[u] = cost;
				
				for(int v : G[u]){
					if(visit[v]) continue;
					pq.add(new int[]{v, cost+C[u][v]});
				}
			}
			
			List<Integer> res = new ArrayList<>(GSet);
			res.sort(Integer::compareTo);
			for(int i : res){
				if(length[i]%2 == 1) bw.write((i+1) + " ");
			}
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}