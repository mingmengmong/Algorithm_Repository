package BOJ.S04000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ04999 {
	public static void BOJ04999(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		System.out.println(
				str1.contains(str2) ? "go" : "no"
		);
		
		
		sc.close();
		bw.close();
		br.close();
	}
}