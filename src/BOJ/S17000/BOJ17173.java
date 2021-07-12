package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ17173 {
	public static void BOJ17173(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		boolean[] bArr = new boolean[N+1];
		int M = sc.nextInt();
		for(int i=0; i<M; ++i){
			int k = sc.nextInt();
			int n = N/k;
			for(int j=1; j<=n; ++j){
				bArr[j*k] = true;
			}
		}
		long sum = 0;
		for(int i=1; i<=N; ++i){
			if(bArr[i]){
				sum += i;
			}
		}
		System.out.println(sum);
		
		sc.close();
		bw.close();
		br.close();
	}
}