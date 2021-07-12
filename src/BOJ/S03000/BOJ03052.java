package BOJ.S03000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ03052 {
	public static void BOJ03052(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<10; ++i){
			int n = sc.nextInt();
			set.add(n%42);
		}
		System.out.println(set.size());
		
		sc.close();
		br.close();
	}
}
