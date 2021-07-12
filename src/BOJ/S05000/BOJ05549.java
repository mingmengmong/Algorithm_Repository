package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ05549 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	// J, O, I
	public static void BOJ05549(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[][][] arr = new int[N+1][M+1][3];
		for(int i=1; i<=N; ++i){
			char[] cArr = br.readLine().toCharArray();
			for(int j=1; j<=M; ++j){
				char c = cArr[j-1];
				if(c == 'J'){
					arr[i][j][0] = 1;
				}else if(c == 'O'){
					arr[i][j][1] = 1;
				}else if(c == 'I'){
					arr[i][j][2] = 1;
				}
				
				for(int k=0; k<3; ++k){
					arr[i][j][k] += (arr[i-1][j][k] + arr[i][j-1][k] - arr[i-1][j-1][k]);
				}
			}
		}
		
		while(K-- > 0){
			st = new StringTokenizer(br.readLine());
			int sR = Integer.parseInt(st.nextToken())-1;
			int sC = Integer.parseInt(st.nextToken())-1;
			int eR = Integer.parseInt(st.nextToken());
			int eC = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<3; ++i){
				bw.write((arr[eR][eC][i]-arr[eR][sC][i]-arr[sR][eC][i]+arr[sR][sC][i]) + " ");
			}
			bw.newLine();
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}