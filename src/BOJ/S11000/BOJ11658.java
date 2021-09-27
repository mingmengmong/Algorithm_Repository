import java.io.*;
import java.util.*;

public class BOJ11658 {
	
	// Use Fenwick Tree

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, MAXN = 1024;
	static int[][] base = new int[MAXN+1][MAXN+1], arr = new int[MAXN+1][MAXN+1];
	
	static int query(int r, int c){
		int res = 0;
		while(c > 0){
			res += arr[r][c];
			c -= (c & -c);
		}
		return res;
	}
	
	static void update(int r, int c, long n){
		while(c <= N){
			arr[r][c] += n;
			c += (c & -c);
		}
	}
	

	public static void BOJ11658(String[] args) throws Exception{
		// br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/kakao_dir/src/main/java/auth_key"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int r=1; r<=N; ++r){
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; ++c){
				int n = Integer.parseInt(st.nextToken());
				base[r][c] = n;
				update(r,c,n);
			}
		}
		
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			if(cmd == 0){
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				update(r,c, n-base[r][c]);
				base[r][c] = n;
			}else{
				int sr = Integer.parseInt(st.nextToken());
				int sc = Integer.parseInt(st.nextToken());
				int er = Integer.parseInt(st.nextToken());
				int ec = Integer.parseInt(st.nextToken());
				int res = 0;
				for(int r=sr; r<=er; ++r){
					res += query(r,ec) - query(r,sc-1);
				}
				bw.write(String.valueOf(res));
				bw.newLine();
			}
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
