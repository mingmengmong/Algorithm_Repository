package BOJ.S10000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ10984 {
	public static void BOJ10984(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; ++tc){
			int N = sc.nextInt();
			int sum = 0;
			double grade = 0;
			for(int i=0; i<N; ++i){
				int C = sc.nextInt();
				double G = sc.nextDouble();
				sum += C;
				grade += G*C;
			}
			grade /= sum;
			System.out.printf("%d %.1f\n", sum, grade);
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}