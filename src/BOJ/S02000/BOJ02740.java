package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02740 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ02740(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] arr1 = new int[n][l];
		for(int i=0; i<n; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<l; ++j){
				arr1[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		int m = Integer.parseInt(st.nextToken());
		int[][] arr2 = new int[l][m];
		for(int i=0; i<l; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; ++j){
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] arr3 = new int[n][m];
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				for(int k=0; k<l; ++k){
					arr3[i][j] += arr1[i][k] * arr2[k][j];
				}
				System.out.print(arr3[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}