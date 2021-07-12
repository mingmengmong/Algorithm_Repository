package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ02981 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static int gcd(int a, int b){
		if(b == 0){
			return a;
		}
		return gcd(b, a%b);
	}
	
	public static void BOJ02981(String[] args) throws Exception {
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		
		int gcd = list.get(1) - list.get(0);
		for(int i=2; i<N; ++i){
			gcd = gcd(gcd, list.get(i)-list.get(i-1));
		}
//		System.out.println(gcd);
		
		Set<Integer> set = new HashSet<>();
		for(int i=1; i<=Math.sqrt(gcd); ++i){
			if(gcd%i == 0){
				set.add(i);
				set.add(gcd/i);
			}
		}
		list = new ArrayList<>(set);
		Collections.sort(list);
		for(int i=1; i<list.size(); ++i){
			bw.write(list.get(i) + " ");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}