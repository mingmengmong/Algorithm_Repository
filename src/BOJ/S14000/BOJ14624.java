package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ14624 {
	public static void BOJ14624(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int r = sc.nextInt();
		if(r%2 == 0){
			System.out.println("I LOVE CBNU");
			return;
		}
		
		for(int i=0; i<r; ++i){
			sb.append("*");
		}
		sb.append("\n");
		
		r /= 2;
		for(int i=0; i<r+1; ++i){
			for(int j=0; j<r-i; ++j){
				sb.append(" ");
			}
			sb.append("*");
			if(i != 0){
				for(int j=0; j<2*(i-1)+1; ++j){
					sb.append(" ");
				}
				sb.append("*");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}