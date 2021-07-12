package BOJ.S10000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10026 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] rd = {1, -1, 0,  0};
	public static int[] cd = {0,  0, 1, -1};
	
	public static void BOJ10026(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[][] arr1 = new int[N][N];
		int[][] arr2 = new int[N][N];
		for(int i=0; i<N; ++i){
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<N; ++j){
				char c = arr[j];
				if('R' == c){
					arr1[i][j] = 1;
					arr2[i][j] = 1;
				}else if('G' == c){
					arr1[i][j] = 2;
					arr2[i][j] = 1;
				}else{
					arr1[i][j] = 3;
					arr2[i][j] = 2;
				}
			}
		}
		
		int result1 = 0;
		int result2 = 0;
		for(int R=0; R<N; ++R){
			for(int C=0; C<N; ++C){
				if(arr1[R][C] > 0){
					++result1;
					List<Integer> list = new ArrayList<>();
					list.add(R*N+C);
					int num = arr1[R][C];
					while(!list.isEmpty()){
						int n = list.remove(0);
						int r = n/N;
						int c = n%N;
						if(arr1[r][c] == 0){
							continue;
						}
						
						arr1[r][c] = 0;
						for(int k=0; k<4; ++k){
							int nr = r + rd[k];
							int nc = c + cd[k];
							try{
								if(arr1[nr][nc] == num){
									list.add(nr*N+nc);
								}
							}catch(Exception e){}
						}
					}
				}
				
				if(arr2[R][C] > 0){
					++result2;
					List<Integer> list = new ArrayList<>();
					list.add(R*N+C);
					int num = arr2[R][C];
					while(!list.isEmpty()){
						int n = list.remove(0);
						int r = n/N;
						int c = n%N;
						if(arr2[r][c] == 0){
							continue;
						}
						
						arr2[r][c] = 0;
						for(int k=0; k<4; ++k){
							int nr = r + rd[k];
							int nc = c + cd[k];
							try{
								if(arr2[nr][nc] == num){
									list.add(nr*N+nc);
								}
							}catch(Exception e){}
						}
					}
				}
			}
		}
		System.out.println(result1 + " " + result2);
		
		sc.close();
		bw.close();
		br.close();
	}
}