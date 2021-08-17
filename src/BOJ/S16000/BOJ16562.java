package BOJ.S16000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ16562 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N, MAX=10_000, M, K;
	public static int[] arr = new int[MAX+1], money = new int[MAX+1];
	public static boolean[] visit = new boolean[MAX+1];
	
	public static int find(int a){
		int aa = arr[a];
		if(aa == a) return a;
		return arr[a] = find(arr[a]);
	}
	
	public static void union(int a, int b){
		int aa = find(a);
		int bb = find(b);
		if(aa == bb) return;
		arr[bb] = aa;
		money[aa] = Math.min(money[aa], money[bb]);
		find(b);
	}
	
	public static void BOJ16562(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; ++i){
			money[i] = Integer.parseInt(st.nextToken());
			arr[i] = i;
		}
		
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(find(a) != find(b)){
				union(a,b);
			}
		}
		
		int sum = 0;
		for(int i=1; i<=N; ++i){
			int aa = find(i);
			if(!visit[aa]) {
				visit[aa] = true;
				sum += money[aa];
			}
		}
		
		if(sum <= K) System.out.println(sum);
		else System.out.println("Oh no");
		
		sc.close();
		bw.close();
		br.close();
	}
}
