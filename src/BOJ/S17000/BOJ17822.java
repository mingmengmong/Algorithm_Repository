package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ17822 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int T;
	public static int[][] arr;
	
	public static void BOJ17822(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int t=0; t<T; ++t){
			st = new StringTokenizer(br.readLine());
			move(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			check();
		}
		
		System.out.println(getSum());
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void move(int x, int d, int k){
		for(int i=x-1; i<N; i+=x){
			for(int j=0; j<k; ++j){
				move(i, d);
			}
		}
	}
	public static void move(int n, int d){
		if(d == 0){
			int num = arr[n][M-1];
			for(int i=M-1; i>0; --i){
				arr[n][i] = arr[n][i-1];
			}
			arr[n][0] = num;
		}else{
			int num = arr[n][0];
			for(int i=0; i<M-1; ++i){
				arr[n][i] = arr[n][i+1];
			}
			arr[n][M-1] = num;
		}
	}
	
	public static void check(){
		Set<Integer> deleteSet = new HashSet<>();
		double sum = 0;
		double cnt = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				int n = arr[i][j];
				if(n == 0){
					continue;
				}
				
				++cnt;
				sum += n;
				
				try{
					if(arr[i-1][j] == n){
						deleteSet.add((i-1)*M+j);
					}
				}catch(Exception e){}
				try{
					if(arr[i+1][j] == n){
						deleteSet.add((i+1)*M+j);
					}
				}catch(Exception e){}
				
				if(arr[i][(j+M+1)%M] == n){
					deleteSet.add(i*M+((j+M+1)%M));
				}
				if(arr[i][(j+M-1)%M] == n){
					deleteSet.add(i*M+((j+M-1)%M));
				}
			}
		}
		
		if(deleteSet.isEmpty()){
			sum /= cnt;
			for(int i=0; i<N; ++i){
				for(int j=0; j<M; ++j){
					int n = arr[i][j];
					if(n == 0){
						continue;
					}
					
					if(sum > (double)n){
						++arr[i][j];
					}else if(sum < (double)n){
						--arr[i][j];
					}
				}
			}
		}else{
			for(int idx : deleteSet){
				int r = idx / M;
				int c = idx % M;
				arr[r][c] = 0;
			}
		}
	}
	
	public static int getSum(){
		int sum = 0;
		for(int i=0; i<N; ++i){
			for(int j=0; j<M; ++j){
				sum += arr[i][j];
			}
		}
		return sum;
	}
}