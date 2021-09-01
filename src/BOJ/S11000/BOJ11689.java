package BOJ.S11000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11689 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static long N;
	
	public static void BOJ11689(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextLong();
		long res = N, n = N;
		
		List<Long> list = new ArrayList<>();
		for(long i=2; i*i<=n; ++i){
			if(n%i == 0){
				list.add(i);
				while(n%i == 0) n /= i;
			}
		}
		if(n != 1) list.add(n);
		
		int size = list.size();
		for(int i=1; i<(1<<size); ++i){
			n = 1;
			int cnt = 0;
			for(int j=0; j<size; ++j){
				if((i & (1<<j)) > 0){
					++cnt;
					n *= list.get(j);
				}
			}
			
			if(cnt % 2 == 0){
				res += N/n;
			}else{
				res -= N/n;
			}
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}