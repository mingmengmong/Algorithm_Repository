package BOJ.S10000;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10775 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, M;
	public static int[] cnt = new int[100];
	public static boolean[][] visit = new boolean[100][1000];
	static{
		Arrays.fill(cnt, 1000);
	}
	
	public static void BOJ10775(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int res = 0;
		for(int i=0; i<M; ++i){
			int g = Integer.parseInt(br.readLine()) - 1;
			int r = g / 1000;
			int c = g % 1000;
			while(r >= 0 && cnt[r] == 0){
				--r;
				c = 999;
			}
			while(true){
				if(r < 0 || c < 0) break;
				if(visit[r][c]){
					--c;
					if(c < 0){
						c = 999;
						--r;
						while(r>=0 && cnt[r] == 0) --r;
					}
				}else{
					break;
				}
			}
			
			if(r < 0 || c < 0) break;
			--cnt[r];
			visit[r][c] = true;
			++res;
		}
		
		System.out.println(res);
		
		sc.close();
		bw.close();
		br.close();
	}
}