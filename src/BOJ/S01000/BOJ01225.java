package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01225 {
	public static void BOJ01225(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		char[] num1 = sc.next().toCharArray();
		char[] num2 = sc.next().toCharArray();
		
		long r = 0;
		for(char n1 : num1){
			for(char n2 : num2){
				r += (n1-'0') * (n2-'0');
			}
		}
		System.out.println(r);
		
		sc.close();
		br.close();
	}
}