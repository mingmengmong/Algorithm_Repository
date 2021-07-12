package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ15651 {
	
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void BOJ15651(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		makeNum(N, M, 0);
		
		bw.flush();
		
		sc.close();
		br.close();
	}
	
	public static int[] arr = new int[7];
	
	public static void makeNum(int n, int m, int cnt) throws Exception{
		if(m == cnt){
			for(int i=0; i<m; ++i){
				bw.write(arr[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=1; i<=n; ++i){
			arr[cnt] = i;
			makeNum(n, m, cnt+1);
		}
	}
}
