package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01547 {
	public static void BOJ01547(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		boolean[] arr = {true, false, false};
		
		for(int i=0; i<n; ++i){
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			boolean temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
		
		for(int i=0; i<3; ++i){
			if(arr[i]){
				System.out.println(i+1);
			}
		}
		
		sc.close();
		br.close();
	}
}