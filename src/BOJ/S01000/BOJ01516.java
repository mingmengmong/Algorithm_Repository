package BOJ.S01000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01516 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static int[] arr;
	public static int[] arr2;
	public static int[] arr3;
	public static List<Integer>[] edge;
	
	public static void BOJ01516(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr2 = new int[N];
		arr3 = new int[N];
		edge = new List[N];
		for(int i=0; i<N; ++i)
			edge[i] = new ArrayList<>();
			
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()){
				int n = Integer.parseInt(st.nextToken()) - 1;
				if(n < 0){
					continue;
				}
				
				
				++arr2[i];
				edge[n].add(i);
			}
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; ++i)
			if (arr2[i] == 0)
				list.add(i);
			
		while(!list.isEmpty()){
			int idx = list.remove(0);
			arr3[idx] += arr[idx];
			for(int next : edge[idx]){
				--arr2[next];
				arr3[next] = Math.max(arr3[next], arr3[idx]);
				if(arr2[next] == 0){
					list.add(next);
				}
			}
		}
		
		for(int i : arr3){
			System.out.println(i);
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}