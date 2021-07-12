package BOJ.S10000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10942 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ10942(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[][] arr2 = new boolean[N][N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i][i] = true;
			for(int j=0; j<i; ++j){
				// i = col, j = row
				int l = (i-j+1)/2;
				boolean b = true;
				for(int k=0; k<l && b; ++k){
					if(arr[j+k] != arr[i-k]){
						b = false;
					}
				}
				arr2[j][i] = b;
			}
		}
		
		for(int i=0; i<N; ++i){
			for(int j=0; j<N; ++j){
				bw.write((arr2[i][j] ? 1 : 0) + " ");
			}
			bw.write("\n");
		}
		
		int K = Integer.parseInt(br.readLine());
		while(K-- > 0){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			bw.write((arr2[s][e] ? 1 : 0) + " \n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}

/*
    0   1   2   3   4   5   6
0  00  01  02  03  04  05  06
1  10  11  12  13  14  15  16
2

 */