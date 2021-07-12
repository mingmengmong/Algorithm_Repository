package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ05086 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static void BOJ05086(String[] args) throws Exception {
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(n1 ==0 && n2 == 0){
				break;
			}
			
			if(n2%n1 == 0){
				bw.write("factor\n");
			}else if(n1%n2 == 0){
				bw.write("multiple\n");
			}else{
				bw.write("neither\n");
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}