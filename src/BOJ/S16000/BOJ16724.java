package BOJ.S16000;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ16724 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int R,C, MAX=1_000;
	public static int[] arr = new int[MAX*MAX+1];
	public static boolean[] visit = new boolean[MAX*MAX+1];
	public static Map<Character, Integer> DIRECTION = new HashMap<>();
	static{
		for(int i=0; i<=MAX*MAX; ++i) arr[i] = i;
		DIRECTION.put('D', 0);
		DIRECTION.put('U', 1);
		DIRECTION.put('R', 2);
		DIRECTION.put('L', 3);
	}
	
	public static int find(int a){
		int aa = arr[a];
		if(aa == a) return a;
		return arr[a] = find(aa);
	}
	
	public static void union(int a, int b){
		int aa = find(a);
		int bb = find(b);
		if(aa == bb) return;
		arr[bb] = aa;
		find(b);
	}
	
	public static void BOJ16724(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input")));
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[] add = new int[]{C, -C, 1, -1};
		for(int i=0; i<R; ++i){
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<C; ++j){
				int u = i*C+j;
				int v = u + add[DIRECTION.get(input[j])];
				if(find(u) != find(v)) union(v,u);
			}
		}
		
		int res = 0;
		for(int i=0; i<R*C; ++i){
			int ii = find(i);
			if(!visit[ii]){
				visit[ii] = true;
				++res;
			}
		}
		
		System.out.println(res);
		
		sc.close();
		bw.close();
		br.close();
	}
}