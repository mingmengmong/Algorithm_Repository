package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01267 {
	public static void BOJ01267(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int r1 = 0;
		int r2 = 0;
		for(int i=0; i<N; ++i){
			int t = sc.nextInt();
			r1 += ((t/30) + 1) * 10;
			r2 += ((t/60) + 1) * 15;
		}
		
		if(r1 < r2){
			System.out.println("Y " + r1);
		}else if(r1 == r2){
			System.out.println("Y M " + r1);
		}else{
			System.out.println("M " + r2);
		}
		
		sc.close();
		br.close();
	}
}