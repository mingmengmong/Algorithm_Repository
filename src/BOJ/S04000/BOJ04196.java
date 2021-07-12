package BOJ.S04000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ04196 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
//	public static boolean[][] E;
	public static Set<Integer>[] E;
	public static Set<Integer>[] RE;
	
	public static boolean[] visit;
	public static Stack<Integer> stack = new Stack<>();
	
	public static int[] arr;
	public static int[] arr2;
	public static Set<Integer>[] EE;
	
	public static void BOJ04196(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			E = new Set[N];
			RE = new Set[N];
			for(int i=0; i<N; ++i){
				E[i] = new HashSet<>();
				RE[i] = new HashSet<>();
			}
			
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken())-1;
				int n2 = Integer.parseInt(st.nextToken())-1;
				E[n1].add(n2);
				RE[n2].add(n1);
			}
			
			visit = new boolean[N];
			for (int i=0; i<N; ++i) {
				if (!visit[i]) {
					dfs(i);
				}
			}
			
			visit = new boolean[N];
			int num = 0;
			arr = new int[N];
			while (!stack.isEmpty()) {
				int n = stack.pop();
				if (!visit[n]) {
					revdfs(n, num);
					++num;
				}
			}
			
			arr2 = new int[num];
			EE = new Set[num];
			for(int i=0; i<num; ++i){
				EE[i] = new HashSet<>();
			}
			for(int i=0; i<N; ++i){
				Set<Integer> iter = E[i];
				for(int j : iter){
					EE[arr[i]].add(arr[j]);
				}
			}
			visit = new boolean[num];
			for(int i=0; i<num; ++i){
				if(!visit[i]){
					ldfs(i);
				}
			}
			
			int cnt = 0;
			for(int i=0; i<num; ++i){
				if(arr2[i] == 0){
					++cnt;
				}
			}
			bw.write(String.format("%d\n", cnt));
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void dfs(int n){
		if(visit[n]){
			return;
		}
		visit[n] = true;
		for(int i : E[n]){
			if(!visit[i]){
				dfs(i);
			}
		}
		stack.push(n);
	}
	
	public static void revdfs(int n, int num){
		if(visit[n]){
			return;
		}
		visit[n] = true;
		for(int i : RE[n]){
			if(!visit[i]){
				revdfs(i, num);
			}
		}
		arr[n] = num;
	}
	
	public static void ldfs(int n){
		if(visit[n]){
			return;
		}
		visit[n] = true;
		for(int i : EE[n]){
			if(!visit[i]){
				arr2[i] = 1;
				ldfs(i);
			}
		}
	}
}