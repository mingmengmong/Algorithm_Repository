package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11066 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ11066(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			long[][] arr = new long[N][N];
			long[][] arr2 = new long[N][N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; ++i){
				arr[0][i] = Long.parseLong(st.nextToken());
			}
			
			for(int i=1; i<N; ++i){
				for(int j=i; j<N; ++j){
					arr[i][j] = arr2[i][j] = arr[i-1][j] + arr[0][j-i];
					if(i > 1){
						long min = Long.MAX_VALUE;
						for(int k=0; k<i; ++k){
							min = Math.min(arr2[k][j-i+k] + arr2[i-1-k][j], min);
						}
						arr2[i][j] += min;
					}
				}
			}
			
			bw.write(arr2[N-1][N-1] + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}