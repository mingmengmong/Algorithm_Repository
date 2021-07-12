package BOJ.S16000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16283 {
	public static void BOJ16283(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		
		/*
		x + y = n
		ax + by = w
		bx + by = bn;
		(a-b)x = w-nb
		x = (w-nb) / (a-b)
		 */
		
		if(a == b){
			if(n == 2 && w == a*2){
				System.out.println("1 1");
			}else {
				System.out.println(-1);
			}
		}else if((w-n*a)%(b-a) != 0){
			System.out.println(-1);
		}else{
			int x = (w-n*b) / (a-b);
			int y = n-x;
			if(x <= 0 || y <= 0){
				System.out.println(-1);
			}else{
				System.out.println(x + " " + y);
			}
		}
		
		sc.close();
		br.close();
	}
}
