package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ15680 {
	public static void BOJ15680(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int r = sc.nextInt();
		if(r == 0){
			bw.write("YONSEI");
		}else{
			bw.write("Leading the Way to the Future");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}