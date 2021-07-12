package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ05337 {
	public static void BOJ05337(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String str = ".  .   .\n" +
				"|  | _ | _. _ ._ _  _\n" +
				"|/\\|(/.|(_.(_)[ | )(/.";
		bw.write(str);
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}