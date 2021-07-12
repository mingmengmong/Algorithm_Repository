package BOJ.S12000;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12850 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAXN = 1_000_000_000, MOD = 1_000_000_007, S = 8;
	public static Map<Integer, int[][]> map = new HashMap<>();
	// 8x8
	public static int[][] base = {
			{0, 1, 1, 0, 0, 0, 0, 0},
			{1, 0, 1, 1, 0, 0, 0, 0},
			{1, 1, 0, 1, 1, 0, 0, 0},
			{0, 1, 1, 0, 1, 1, 0, 0},
			{0, 0, 1, 1, 0, 1, 1, 0},
			{0, 0, 0, 1, 1, 0, 0, 1},
			{0, 0, 0, 0, 1, 0, 0, 1},
			{0, 0, 0, 0, 0, 1, 1, 0}
	};
	
	// start = {1, 0, 0, 0, 0, 0, 0, 0}
	static{
		map.put(1, base);
	}
	
	// top-down
	public static void dfs(int idx){
		if(idx == 1) return;
		
		int pIdx = idx >> 1;
		if(map.get(pIdx) == null) dfs(pIdx);
		map.put(idx, mul(pIdx, (idx&1) == 1));
	}
	
	public static int[][] mul(int n1, boolean isOne){
		int[][] a = map.get(n1);
		int[][] res = new int[S][S];
		for(int r=0; r<S; ++r){
			for(int c=0; c<S; ++c){
				long s = 0;
				for(int k=0; k<S; ++k){
					s += (long) a[r][k] * (long) a[k][c];
				}
				s %= MOD;
				res[r][c] = (int) (s % MOD);
			}
		}
		
		if(isOne){
			int[][] res2 = new int[S][S];
			for(int r=0; r<S; ++r){
				for(int c=0; c<S; ++c){
					long s = 0;
					for(int k=0; k<S; ++k){
						s += (long) res[r][k] * (long) base[k][c];
					}
					s %= MOD;
					res2[r][c] = (int) (s % MOD);
				}
			}
			return res2;
		}
		
		return res;
	}
	
	public static void BOJ12850(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		N = Integer.parseInt(br.readLine());
		dfs(N);
		System.out.println(map.get(N)[0][0]);
		
		sc.close();
		bw.close();
		br.close();
	}
}