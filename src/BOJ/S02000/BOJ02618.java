import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ02618 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, W, MAXW=1_000;
	static int[] car1 = {1,1}, car2={0,0};
	static int[][] arr = new int[MAXW+1][2];
	static int[][] dp = new int[MAXW+1][MAXW+1];
	static int[] save = new int[MAXW+1];
	static{
		for(int i=0; i<=MAXW; ++i) Arrays.fill(arr[i], -1);
		for(int i=0; i<=MAXW; ++i) Arrays.fill(dp[i], -1);
	}
	
	static int distance(int[] p1, int[] p2){
		return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
	}
	
	static int dp(int idx1, int idx2){
//		System.out.printf("%d %d\n", idx1, idx2);
		if(idx1 == W || idx2 == W) return dp[idx1][idx2] = 0;
		if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
		int maxIdx = Math.max(idx1, idx2) + 1;
		// car1 move
		int idx1Res = dp(maxIdx, idx2) + distance(arr[maxIdx], idx1 == 0 ? car1 : arr[idx1]);
		// car2 move
		int idx2Res = dp(idx1, maxIdx) + distance(arr[maxIdx], idx2 == 0 ? car2 : arr[idx2]);
		
		return dp[idx1][idx2] = Math.min(idx1Res, idx2Res);
	}
	
	static void setSave(int idx1, int idx2){
		if(idx1 == W || idx2 == W) return;
		int maxIdx = Math.max(idx1, idx2) + 1;
		// car1 move
		int idx1Res = dp(maxIdx, idx2) + distance(arr[maxIdx], idx1 == 0 ? car1 : arr[idx1]);
		// car2 move
		int idx2Res = dp(idx1, maxIdx) + distance(arr[maxIdx], idx2 == 0 ? car2 : arr[idx2]);
		
		if(idx1Res < idx2Res){
			save[maxIdx] = 1;
			setSave(maxIdx, idx2);
		}else{
			save[maxIdx] = 2;
			setSave(idx1, maxIdx);
		}
	}
	
	public static void BOJ02618(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		W = sc.nextInt();
		car2[0] = N; car2[1] = N;
		for(int i=1; i<=W; ++i){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		System.out.println(dp(0,0));
		
		setSave(0, 0);
		for(int i=1; i<=W; ++i) System.out.println(save[i]);
		
		br.close();
		bw.close();
		sc.close();
	}
}