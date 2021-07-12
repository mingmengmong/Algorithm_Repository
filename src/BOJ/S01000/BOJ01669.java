package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01669 {
	public static void BOJ01669(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = y-x;
		
		if(d == 0){
			System.out.println(0);
			return;
		}
		
		int rd = (int) Math.sqrt(d);
		int r = 0;
		if((rd*rd) == d){
			r = rd*2-1;
		}else if((rd*rd+rd) >= d){
			r = rd*2;
		}else{
			r = rd*2+1;
		}
		
		System.out.println(r);
		
		sc.close();
		br.close();
	}
}