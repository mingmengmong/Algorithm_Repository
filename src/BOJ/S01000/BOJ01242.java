package BOJ.S01000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01242 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N,K,M;
	
	public static void BOJ01242(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		K = sc.nextInt();
		M = sc.nextInt();
		
		int res = 0;
		for(int n = 1; n <= N; n++){
			int nK= K%(N-n+1)==0? N-n+1:K%(N-n+1);
			if (M==nK) {
				res = n;
				break;
			}
			M = M>nK ? M-nK : (M-nK)+N-n+1;
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}