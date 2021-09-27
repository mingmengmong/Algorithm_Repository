import java.io.*;
import java.util.*;

public class BOJ01068 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX = 50, root;
	static int[] par, cnt;
	static{
		par = new int[MAX+1];
		cnt = new int[MAX+1];
		Arrays.fill(par, -1);
		Arrays.fill(cnt, 0);
	}
	
	public static void BOJ01068(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		for(int i=0; i<N; ++i){
			int n = sc.nextInt();
			if(n == -1){
				root = i;
				continue;
			}
			
			par[i] = n;
			++cnt[n];
		}
		
		int delIdx = sc.nextInt();
		if(delIdx == root){
			System.out.println(0);
			return;
		}
		
		--cnt[par[delIdx]];
		par[delIdx] = -1;
		int res = 0;
		for(int i=0; i<N; ++i){
			if(cnt[i] != 0) continue;
			int p = i;
			while(!(p == root || p == -1)){
				p = par[p];
			}
			if(p == root) ++res;
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}