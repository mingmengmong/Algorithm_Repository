package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01244 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M;
	static int[] arr;
	
	public static void BOJ01244(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		//sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for(int query=0; query<M; ++query){
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(sex == 1){
				for(int i=idx; i<=N; i+=idx){
					arr[i] ^= 1;
				}
			}else{
				arr[idx] ^= 1;
				for(int l=idx-1, r=idx+1; l>=1&&r<=N; --l,++r){
					if(arr[l] == arr[r]){
						arr[l] ^= 1;
						arr[r] ^= 1;
					}else{
						break;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; ++i) {
			sb.append(arr[i] + " ");
			if(i%20 == 0) sb.append("\n");
		}
		System.out.println(sb.toString());
		
		br.close();
		bw.close();
		sc.close();
	}
}