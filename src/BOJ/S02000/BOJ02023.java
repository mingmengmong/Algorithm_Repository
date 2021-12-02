import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ02023 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static boolean[] prime = new boolean[100_001];
	static {
		prime[0] = prime[1] = true;
		for(int i=2; i<=330; ++i) {
			if(prime[i]) continue;
			for(int j=i+i; j<=100_000; j+=i)
				prime[j] = true;
		}
	}
	
	static boolean isPrime(int num){
		for(int i=2; i*i<=num; ++i){
			if(!prime[i] && num % i == 0) return false;
		}
		return true;
	}
			
	public static void BOJ02023(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> now = new HashSet<>();
		now.add(2);
		now.add(3);
		now.add(5);
		now.add(7);
		for(int i=2; i<=N; ++i){
			Set<Integer> set = new HashSet<>();
			for(int n : now){
				n *= 10;
				for(int j=1; j<10; j+=2){
					if(N < 5 && !prime[n+j]) set.add(n+j);
					else if(N >= 5 && isPrime(n+j)) set.add(n+j);
				}
			}
			now = set;
		}
		
		List<Integer> res = new ArrayList<>(now);
		res.sort(Integer::compareTo);
		for(int n : res){
			bw.write(String.valueOf(n));
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}