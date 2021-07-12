package BOJ.S10000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ10926 {
	public static void BOJ10926(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		bw.write(str);
		bw.write("??!");
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}