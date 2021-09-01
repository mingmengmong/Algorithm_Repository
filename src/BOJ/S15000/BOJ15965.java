package BOJ.S15000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ15965 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int MAX = 7_368_790;
	static boolean[] visit = new boolean[MAX+1];
	
	public static void BOJ15965(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		visit[0] = visit[1] = true;
		for(int i=2; i<=Math.sqrt(MAX) + 1; ++i){
			if(visit[i]) continue;
			for(int j=i+i; j<=MAX; j+=i){
				visit[j] = true;
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=2; i<=MAX; ++i){
			if(visit[i]) continue;
			if(++cnt == n){
				System.out.println(i);
				break;
			}
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}