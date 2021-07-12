package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02096 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ02096(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[][] maxArr = new int[N+1][3];
		int[][] minArr = new int[N+1][3];
		for(int i=1; i<=N; ++i){
			st = new StringTokenizer(br.readLine());
			int n0 = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			maxArr[i][0] = Math.max(maxArr[i-1][0], maxArr[i-1][1]) + n0;
			maxArr[i][1] = Math.max(maxArr[i-1][0], Math.max(maxArr[i-1][1], maxArr[i-1][2])) + n1;
			maxArr[i][2] = Math.max(maxArr[i-1][2], maxArr[i-1][1]) + n2;
			
			minArr[i][0] = Math.min(minArr[i-1][0], minArr[i-1][1]) + n0;
			minArr[i][1] = Math.min(minArr[i-1][0], Math.min(minArr[i-1][1], minArr[i-1][2])) + n1;
			minArr[i][2] = Math.min(minArr[i-1][2], minArr[i-1][1]) + n2;
		}
		
		System.out.printf("%d %d\n",
				Math.max(maxArr[N][0], Math.max(maxArr[N][1], maxArr[N][2])),
				Math.min(minArr[N][0], Math.min(minArr[N][1], minArr[N][2])));
		
		sc.close();
		bw.close();
		br.close();
	}
}