package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02252 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static List<Integer>[] arr;
	public static List<Integer> list = new ArrayList<>();
	public static int[] degree;
	
	public static void BOJ02252(String[] args) throws Exception {
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
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			++degree[b];
			arr[a].add(b);
		}
		
		for(int i=1; i<=N; ++i){
			if(degree[i] == 0){
				list.add(i);
			}
		}
		
		while(!list.isEmpty()){
			int temp = list.remove(0);
			
			System.out.printf("%d ", temp);
			
			for(int i : arr[temp]){
				if (--degree[i] == 0)
					list.add(i);
			}
		}
		System.out.println();
		
		sc.close();
		bw.close();
		br.close();
	}
}