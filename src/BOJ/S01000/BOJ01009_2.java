package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01009_2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int TC, N, M;
	public static int[] l = {1,1,4,4,2,1,1,4,4,2};
	public static int[][] arr = {
			{10},
			{1},
			{2,4,8,6},
			{3,9,7,1},
			{4,6},
			{5},
			{6},
			{7,9,3,1},
			{8,4,2,6},
			{9,1}
	};
	
	public static void BOJ01009_2(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()) % 10;
			M = (Integer.parseInt(st.nextToken()) - 1) % l[N];
			bw.write("" + arr[N][M]);
			bw.newLine();
		}
		
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}