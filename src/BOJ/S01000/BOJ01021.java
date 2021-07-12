package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ01021 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void BOJ01021(String[] args) throws Exception {
		int N = sc.nextInt();
		int M = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; ++i){
			list.add(i);
		}
		
		int result = 0;
		for(int i=0; i<M; ++i){
			int n = sc.nextInt();
			int idx = list.indexOf(n);
			if(idx != 0){
				result += Math.min(idx, N-i-idx);
				for(int j=0; j<idx; ++j){
					list.add(list.remove(0));
				}
			}
			list.remove(0);
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}