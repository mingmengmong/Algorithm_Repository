package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ01049 {
	public static void BOJ01049(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int n1 = N/6;
		int n2 = N%6;
		
		int[] arrP = new int[M];
		int[] arrN = new int[M];
		for(int i=0; i<M; ++i){
			int p = sc.nextInt();
			int n = sc.nextInt();
			
			arrP[i] = n1 * Math.min(p, 6*n);
			arrN[i] = (n2>0?1:0) * Math.min(p, n2*n);
		}
		
		Arrays.sort(arrP);
		Arrays.sort(arrN);
		
		System.out.println(arrP[0] + arrN[0]);
		
		
		
		
		
		sc.close();
		br.close();
	}
}