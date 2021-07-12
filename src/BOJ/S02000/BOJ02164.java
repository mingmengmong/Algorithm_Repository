package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ02164 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void BOJ02164(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		if(N == 1){
			System.out.println(1);
			return;
		}
		
		int n = 0;
		int k = N;
		while(k > 0){
			++n;
			k/=2;
		}
		n = (int) Math.pow(2, n-1);
		if(n == N){
			System.out.println(n);
		}else{
			System.out.println(2*(N-n));
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}