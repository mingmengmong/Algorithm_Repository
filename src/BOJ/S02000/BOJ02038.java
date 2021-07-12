package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02038 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ02038(String[] args) throws Exception {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{
			put(1, 1);
		}};
		
		int N = sc.nextInt();
		if(N == 1){
			System.out.println(1);
			return;
		}
		int sum = 1;
		int i=2;
		for(; i<=N; ++i){
			int fn = 1 + map.get(i-map.get(map.get(i-1)));
			map.put(i, fn);
			sum += fn;
			if(sum >= N){
				break;
			}
		}
		System.out.println(i);
		
		sc.close();
		bw.close();
		br.close();
	}
}