package BOJ.S10000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ10448 {
	public static void BOJ10448(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = 45;
		int[] arr = new int[N];
		arr[0] = 1;
		for(int i=1; i<N; ++i){
			arr[i] = arr[i-1] + i+1;
		}
		
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; tc++){
			int c = sc.nextInt();
			boolean b = false;
			for(int i=0; i<N && !b && c>=arr[i]; ++i){
				int t = c-arr[i];
				for(int j=0; j<N && !b && t>=arr[j]; ++j){
					int tt = t-arr[j];
					for(int k=0; k<N && !b && tt>=arr[k]; ++k){
						if((tt-arr[k]) == 0){
							b=true;
						}
					}
				}
			}
			
			System.out.println(b?1:0);
		}
		
		sc.close();
		br.close();
	}
}
