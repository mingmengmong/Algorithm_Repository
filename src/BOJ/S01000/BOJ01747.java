package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01747 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int MAX = 1_003_100;
	static boolean[] visit = new boolean[MAX+1];
	
	static boolean check(int n){
		if(visit[n]) return false;
		char[] str = String.valueOf(n).toCharArray();
		int l = str.length;
		for(int j=0; j<(l>>>1); ++j){
			if(str[j] != str[l-j-1]) return false;
		}
		return true;
	}
	
	public static void BOJ01747(String[] args) throws Exception {
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
		for(int i=n; i<=MAX; ++i){
			if(check(i)){
				System.out.println(i);
				break;
			}
		}
		
		
		
		br.close();
		bw.close();
		sc.close();
	}
}