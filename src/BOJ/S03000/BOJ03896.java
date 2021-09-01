package BOJ.S03000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ03896 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int MAX = 1_299_709;
	static int[] left = new int[MAX+1], right = new int[MAX+1];
	static boolean[] visit = new boolean[MAX+1];
	
	public static void BOJ03896(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		for(int i=2; i<=Math.sqrt(MAX) + 1; ++i){
			if(visit[i]) continue;
			for(int j=i+i; j<=MAX; j+=i){
				visit[j] = true;
			}
		}
		visit[0] = false;
		visit[1] = true;
		left[0] = -1;
		for(int i=0; i<=MAX; ++i){
			if(!visit[i]) left[i] = i;
			else left[i] = left[i-1];
			
			if(!visit[MAX-i]) right[MAX-i] = MAX-i;
			else right[MAX-i] = right[MAX-i+1];
		}
		
		
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int n = Integer.parseInt(br.readLine());
			if(!visit[n]) System.out.println(0);
			else System.out.println(right[n] - left[n]);
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}