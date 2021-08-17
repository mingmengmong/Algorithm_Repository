package BOJ.S17000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17371 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	// 각 좌표에서 제일 먼 좌표와의 거리 배열에서 가장 짧은 거리의 좌표가 정답
	public static int N, MAXN = 1_000, dist = Integer.MAX_VALUE, res = 0;
	public static int[] X = new int[MAXN], Y = new int[MAXN], arr = new int[MAXN];
	
	public static int cal(int i, int j){
		return (X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j]);
	}
	
	public static void BOJ17371(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				if(i == j) continue;
				arr[i] = Math.max(arr[i], cal(i,j));
			}
		}
		
		for(int i=0; i<N; ++i){
			if(arr[i] < dist){
				dist = arr[i];
				res = i;
			}
		}
		
		System.out.printf("%d %d\n", X[res], Y[res]);
		
		sc.close();
		bw.close();
		br.close();
	}
}