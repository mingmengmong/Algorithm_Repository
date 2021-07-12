package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11403 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	
	public static void BOJ11403(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
//		boolean[][] arr = new boolean[N][N];
		List<Integer>[] arr = new List[N];
		for(int i=0; i<N; ++i){
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; ++j){
				if(Integer.parseInt(st.nextToken()) == 1){
					arr[i].add(j);
				}
			}
		}
		
		int[][] result = new int[N][N];
		for(int i=0; i<N; ++i){
			boolean[] bArr = new boolean[N];
			List<Integer> list = new ArrayList<>();
			for(int iter : arr[i]){
				list.add(iter);
			}
			
			while(!list.isEmpty()){
				int n = list.remove(0);
				if(bArr[n]){
					continue;
				}
				
				bArr[n] = true;
				result[i][n] = 1;
				for(int iter : arr[n]){
					if(!bArr[iter]){
						list.add(iter);
					}
				}
			}
		}
		
		sb = new StringBuilder();
		for(int i=0; i<N; ++i){
			sb.append(result[i][0]);
			for(int j=1; j<N; ++j){
				sb.append(" " + result[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		sc.close();
		bw.close();
		br.close();
	}
}