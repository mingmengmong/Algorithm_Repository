package BOJ.S16000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ16566 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static int K;
	
	public static void BOJ16566(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] cntArr = new int[2000];
		boolean[][] bArr = new boolean[2000][2000];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; ++i){
			int num = Integer.parseInt(st.nextToken())-1;
			int n = num / 2000;
			int m = num % 2000;
			cntArr[n]++;
			bArr[n][m] = true;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<K; ++i){
			int num = Integer.parseInt(st.nextToken());
			int n = num / 2000;
			int m = num % 2000;
			
			while(cntArr[n] == 0){
				n++;
				m = 0;
			}
			
			while(true){
				if(bArr[n][m]){
					bArr[n][m] = false;
					cntArr[n]--;
					bw.write((n*2000+m+1) + "\n");
					break;
				}else{
					m++;
					if(m == 2000){
						m = 0;
						n++;
					}
				}
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}