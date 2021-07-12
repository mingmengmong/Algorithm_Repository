package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ01145 {
	public static void BOJ01145(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int[] arr = new int[5];
		List<Integer> rList = new ArrayList<>();
		
		for(int i=0; i<5; ++i){
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<3; ++i){
			for(int j=i+1; j<4; ++j){
				for(int k=j+1; k<5; ++k){
					int a = arr[i];
					int b = arr[j];
					int c = arr[k];
					
					int ab = a*b/gcd(a,b);
					int abc = ab*c/gcd(ab,c);
					rList.add(abc);
				}
			}
		}
		
		Collections.sort(rList);
		System.out.println(rList.get(0));
		
		sc.close();
		br.close();
	}
	
	public static int gcd(int a, int b){
		return (b==0 ? a : gcd(b, a%b));
	}
}