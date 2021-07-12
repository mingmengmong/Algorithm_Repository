package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ02798 {
	public static void BOJ02798(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; ++i){
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;
		for(int i=0; i<N-2; ++i){
			for(int j=i+1; j<N-1; ++j){
				for(int k=j+1; k<N; ++k){
					int s = arr[i] + arr[j] + arr[k];
					if(s <= M){
						sum = Math.max(sum, s);
					}
				}
			}
		}
		
		System.out.println(sum);
		
		sc.close();
		br.close();
	}
}
