package BOJ.S06000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ06064 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ06064(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int result = -1;
			for(int i=0; i<n; ++i){
				if((i*m+x)%n == y){
					result = i*m+x+1;
					break;
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}