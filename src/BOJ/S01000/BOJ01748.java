package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01748 {
	public static void BOJ01748(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		String nStr = sc.next();
		int length = nStr.length();
		long r = 0;
		for(int i=1; i<=length; ++i){
			if(i == length){
				int n1 = (int) Math.pow(10, i-1);
				r += i * (Integer.parseInt(nStr) - n1 + 1);
			}else{
				int n1 = (int) Math.pow(10, i-1);
				int n2 = (int) Math.pow(10, i);
				r += i * (n2-n1);
			}
		}
		
		System.out.println(r);
		
		sc.close();
		br.close();
	}
}