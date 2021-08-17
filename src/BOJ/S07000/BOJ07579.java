package BOJ.S07000;
import java.io.*;
import java.util.*;

public class BOJ07579 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAXN = 100, MAXC = 100 * 100, res = Integer.MAX_VALUE;
	static int[][] arr, dp = new int[MAXN+1][MAXC+1];
	static Set<Integer> set = new HashSet<>();
	static List<Integer> list = new ArrayList<>();
	
	static{
		for(int i=0; i<=MAXN; ++i) Arrays.fill(dp[i], -1);
		dp[0][0] = 0;
		set.add(0);
	}
	
	public static void BOJ07579(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][2];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i][0] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i][1] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr, (ar1,ar2) -> {
			if(ar1[1] == ar2[1]) return Integer.compare(ar2[0], ar1[0]);
			return Integer.compare(ar1[1], ar2[1]);
		});
		
		for(int i=1; i<=N; ++i){
			int m = arr[i-1][0];
			int cost = arr[i-1][1];
			
			list = new ArrayList<>(set);
//			list.sort(Integer::compareTo);
			
			for(int prevCost : list){
				if(dp[i][prevCost] == -1) dp[i][prevCost] = dp[i-1][prevCost];
				
				int nowCost = prevCost + cost;
				dp[i][nowCost] = dp[i-1][prevCost] + m;
				if(dp[i-1][nowCost] != -1) dp[i][nowCost] = Math.max(dp[i-1][nowCost], dp[i][nowCost]);
				
				if(dp[i][nowCost] >= M){
					res = Math.min(res, nowCost);
				}else{
					set.add(nowCost);
				}
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}