package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ01149 {
	public static void BOJ01149(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		if(N == 0){
			System.out.println(0);
			return;
		}
		int[][] iArr = new int[3][N];
		iArr[0][0] = sc.nextInt();
		iArr[1][0] = sc.nextInt();
		iArr[2][0] = sc.nextInt();
		
		for(int i=1; i<N; ++i){
			iArr[0][i] = Math.min(iArr[1][i-1], iArr[2][i-1]) + sc.nextInt();
			iArr[1][i] = Math.min(iArr[0][i-1], iArr[2][i-1]) + sc.nextInt();
			iArr[2][i] = Math.min(iArr[0][i-1], iArr[1][i-1]) + sc.nextInt();
		}
		
		System.out.println(Math.min(Math.min(iArr[0][N-1], iArr[1][N-1]), iArr[2][N-1]));
		
		sc.close();
		bw.close();
		br.close();
	}
}