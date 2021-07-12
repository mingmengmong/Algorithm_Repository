package BOJ.S16000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ16673 {
	public static void BOJ16673(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int C = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();
		
		long sum = 0;
		for(int i=1; i<=C; ++i){
			sum += K*i + P*i*i;
		}
		System.out.println(sum);
		
		sc.close();
		bw.close();
		br.close();
	}
}