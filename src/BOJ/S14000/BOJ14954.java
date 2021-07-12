package BOJ.S14000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ14954 {
	public static void BOJ14954(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		Set<Integer> st = new HashSet<>();
		while(true){
			if(st.contains(N)){
				break;
			}
			st.add(N);
			N = fn(N);
		}
		
		System.out.println(st.contains(1) ? "HAPPY" : "UNHAPPY");
		
		sc.close();
		br.close();
	}
	
	public static int fn(int n){
		int sum = 0;
		while(n != 0){
			int nn = n%10;
			sum += Math.pow(nn, 2);
			n /= 10;
		}
		return sum;
	}
}
