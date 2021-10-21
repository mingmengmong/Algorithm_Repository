import java.io.*;
import java.util.*;

public class BOJ02026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int K, N, F, MAX = 900;
	static boolean flag = false;
	static boolean[][] G = new boolean[MAX+1][MAX+1];
	static int[] fCntArr = new int[MAX+1];
	static Set<Integer> set = new HashSet<>();
	static List<Integer> list = new ArrayList<>();
	
	static void comb(int u){
		if(flag) return;
		if(!flag && set.size() == K){
			flag = true;
			list = new ArrayList<>(set);
			list.sort(Integer::compareTo);
			return;
		}
		
		aaa : for(int i=u+1; i<=N && !flag; ++i){
			if(!G[u][i]) continue;
			if(fCntArr[i] < K-1) continue;
			for(int vv : set){
				if(!G[i][vv]) continue aaa;
			}
			
			set.add(i);
			comb(i);
			set.remove(i);
		}
	}
	
	public static void BOJ02026 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<F; ++i){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			G[u][v] = true;
			G[v][u] = true;
			++fCntArr[u];
			++fCntArr[v];
		}
		
		for(int i=1; i<=N && !flag; ++i){
			if(fCntArr[i] < K-1) continue;
			set.add(i);
			comb(i);
			set.remove(i);
		}
		
		if(!flag) System.out.println(-1);
		else for(int i : list) System.out.println(i);
		
		br.close();
		bw.close();
		sc.close();
	}
}