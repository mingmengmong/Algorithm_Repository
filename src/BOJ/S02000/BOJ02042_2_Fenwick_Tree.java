import java.io.*;
import java.util.*;

public class BOJ02042_2_Fenwick_Tree {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, MAXN = 1_000_000;
	static long[] base = new long[MAXN +1], arr = new long[MAXN +1];
	
	static long query(int i){
		long res = 0;
		while(i > 0){
			res += arr[i];
			i -= (i & -i);
		}
		return res;
	}
	
	static void update(int i, long n){
		while(i <= N){
			arr[i] += n;
			i += (i & -i);
		}
	}
	
	public static void BOJ02042_2_Fenwick_Tree(String[] args) throws Exception{
		// br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/kakao_dir/src/main/java/auth_key"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; ++i){
			long n = Long.parseLong(br.readLine());
			base[i] = n;
			update(i, n);
		}
		
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if(cmd == 1){
				int i = Integer.parseInt(st.nextToken());
				long n = Long.parseLong(st.nextToken());
				update(i, n - base[i]);
				base[i] = n;
			}else{
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				bw.write(String.valueOf(query(e) - query(s-1)));
				bw.newLine();
			}
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
