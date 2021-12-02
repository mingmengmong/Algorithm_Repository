import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ05014 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int F, S, G, U, D, MAX=1_000_000;
	static int[] dp = new int[MAX+1];
	static boolean[] visit = new boolean[MAX+1];
	
	public static void BOJ05014(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		Arrays.fill(dp, -1);
		dp[S] = 0;
		
		List<Integer> list = new LinkedList<>();
		list.add(S);
		boolean flag = false;
		while(!list.isEmpty()){
			int f = list.remove(0);
			if(f == G){
				flag = true;
				break;
			}
			
			if(visit[f]) continue;
			visit[f] = true;
		
			if(f+U <= F && !visit[f+U]){
				dp[f+U] = dp[f] + 1;
				list.add(f+U);
			}
			if(f-D > 0 && !visit[f-D]){
				dp[f-D] = dp[f] + 1;
				list.add(f-D);
			}
		}
		
		System.out.println((flag ? dp[G] : "use the stairs"));
		
		
		br.close();
		bw.close();
		sc.close();
	}
}