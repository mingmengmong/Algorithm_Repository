package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02623 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static List<Integer>[] arr;
	public static List<Integer> list = new ArrayList<>();
	public static int[] degree;
	
	public static void BOJ02623(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new List[N+1];
		degree = new int[N+1];
		for(int i=1; i<=N; ++i){
			arr[i] = new ArrayList<>();
		}
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for(int j=1; j<n; ++j){
				int b = Integer.parseInt(st.nextToken());
				++degree[b];
				arr[a].add(b);
				a = b;
			}
		}
		
		for(int i=1; i<=N; ++i){
			if(degree[i] == 0){
				list.add(i);
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		while(!list.isEmpty()){
			int num = list.remove(0);
			
			ans.add(num);
			
			for(int i : arr[num]){
				if (--degree[i] == 0)
					list.add(i);
			}
		}
		
		if(ans.size() != N){
			System.out.println(0);
		}else{
			for(int i : ans){
				System.out.println(i);
			}
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}