package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01712 {
	public static void BOJ01712(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = C-B;
		if(D<=0){
			System.out.println(-1);
		}else{
			System.out.println((A/D)+1);
		}
		
		sc.close();
		br.close();
	}
}
