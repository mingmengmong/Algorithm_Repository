package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ02562 {
	public static void BOJ02562(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int index = -1;
		int max = -1;
		
		for(int i=1; i<=9; ++i){
			int n = sc.nextInt();
			if(n > max){
				max = n;
				index = i;
			}
		}
		
		System.out.println(max);
		System.out.println(index);
		
		sc.close();
		br.close();
	}
}
