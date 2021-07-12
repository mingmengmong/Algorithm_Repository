package BOJ.S13000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ13458 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ13458(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		List<Long> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			list.add(Long.parseLong(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		long m1 = Long.parseLong(st.nextToken());
		long m2 = Long.parseLong(st.nextToken());
		long result = N;
		for(long l : list){
			long l2 = l - m1;
			if(l2 > 0){
				result += l2/m2 + (l2%m2 == 0 ? 0 : 1);
			}
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}