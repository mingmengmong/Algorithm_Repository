package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ17211 {
	public static void BOJ17211(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int mood = sc.nextInt();
		double ff = sc.nextDouble();
		double fs = sc.nextDouble();
		double sf = sc.nextDouble();
		double ss = sc.nextDouble();
		
		double f = mood == 0 ? 1f : 0f;
		double s = mood == 1 ? 1f : 0f;
		
		for(int i=0; i<N; ++i){
			double nf = 0f;
			double ns = 0f;
			nf = ff * f + sf * s;
			ns = fs * f + ss * s;
			
			f = nf;
			s = ns;
		}
		
		System.out.printf("%.0f\n%.0f\n", (f*1000), (s*1000));
		
		sc.close();
		bw.close();
		br.close();
	}
}