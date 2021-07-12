package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02098 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int[][] arr;
	public static int[][] cArr;
	
	public static int check;
	public static int MAX = 1000000000;
	
	public static int find(int checkNum, int idx){
		if(check == checkNum){
			return arr[idx][0];
		}
		
		if(cArr[idx][checkNum] != 0){
			return cArr[idx][checkNum];
		}
		
		int result = MAX;
		for(int i=0; i<N; ++i){
			int c = 1 << i;
			if((checkNum & c) > 0)
				continue;
			if(arr[idx][i] == 0)
				continue;
			int r = find(checkNum+c, i);
			if(r >= MAX)
				continue;
			result = Math.min(r+arr[idx][i], result);
		}
		
		return cArr[idx][checkNum] = result;
	}
	
	public static void BOJ02098(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; ++i){
			check += 1 << i;
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				int l = Integer.parseInt(st.nextToken());
				arr[i][j] = l != 0 ? l : MAX;
			}
		}
		
//		System.out.println(Integer.toBinaryString(check));
		
		cArr = new int[N][check+1];
		
		int length = find(1, 0);
		
		System.out.println(length);
		
		sc.close();
		bw.close();
		br.close();
	}
}