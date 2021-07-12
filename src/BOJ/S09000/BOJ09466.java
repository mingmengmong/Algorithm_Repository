package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ09466 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int[] arr;
	public static boolean[] visit;
	public static boolean[] already;
	
	public static void BOJ09466(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; ++i){
				arr[i] = Integer.parseInt(st.nextToken()) - 1;
			}
			
			int cnt = 0;
			visit = new boolean[N];
			already = new boolean[N];
			
			for(int i=0; i<N; ++i){
				dfs(i);
				if(!already[i]){
					++cnt;
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	private static void dfs(int i) {
		// TODO Auto-generated method stub
		if(visit[i] || already[i])
			return;
		
		ArrayList<Integer> arrList = new ArrayList<>();
		int now = i;
		
		while(!visit[now] && !already[now]) {
			visit[now] = true;
			arrList.add(now);
			now = arr[now];
		}
		int index=0;
		for(; index<arrList.size(); index++) {
			if(arrList.get(index) == now)
				break;
		}
		
		for(; index<arrList.size(); index++) {
			already[arrList.get(index)] = true;
		}
	}
}