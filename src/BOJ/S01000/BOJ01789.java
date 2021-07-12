package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01789 {
	public static void BOJ01789(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextLong();
		long sqrt = (long) Math.sqrt(S*2);
		while(true){
			if(sqrt*(sqrt+1) <= S*2){
				break;
			}
			--sqrt;
		}
		System.out.println(sqrt);
		
		sc.close();
		br.close();
	}
}