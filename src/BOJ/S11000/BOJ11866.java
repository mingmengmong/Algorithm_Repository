package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ11866 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void BOJ11866(String[] args) throws Exception {
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=N; ++i){
			list.add(i);
		}
		
		List<Integer> result = new ArrayList<>();
		int idx = 0;
		while(list.size() > 0){
			idx = (idx + K - 1) % list.size();
			result.add(list.remove(idx));
		}
		
		String r = result.toString();
		System.out.printf("<%s>\n", r.substring(1, r.length()-1));
		
		sc.close();
		bw.close();
		br.close();
	}
}