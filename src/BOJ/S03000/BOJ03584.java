import java.io.*;
import java.util.*;

public class BOJ03584 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	
	public static void BOJ03584(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			int[] par = new int[N+1];
			List<Integer>[] G = new List[N+1];
			for(int i=0; i<=N; ++i) G[i] = new ArrayList<>();
			for(int i=0; i<N-1; ++i){
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				par[B] = A;
				G[A].add(B);
			}
			
			
			int root = -1;
			for(int i=1; i<=N; ++i)
				if(par[i] == 0) {
					root = i;
					break;
				}
			
			List<Integer> list = new ArrayList<>();
			int[] depth = new int[N+1];
			list.add(root);
			while(!list.isEmpty()){
				int n = list.remove(0);
				depth[n] = depth[par[n]]+1;
				for(int c : G[n]){
					list.add(c);
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			while(depth[a] > depth[b]){
				a = par[a];
			}
			while(depth[a] < depth[b]){
				b = par[b];
			}
			while(a != b){
				a = par[a];
				b = par[b];
			}
			System.out.println(a);
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}