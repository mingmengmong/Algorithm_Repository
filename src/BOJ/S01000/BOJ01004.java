package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01004 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ01004(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			
			int result = 0;
			int CNT = Integer.parseInt(br.readLine());
			while(CNT-- > 0){
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				
				boolean bs = isIn(sr, sc, r, c, l);
				boolean be = isIn(er, ec, r, c, l);
				result += bs != be ? 1 : 0;
			}
			bw.write(result + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static boolean isIn(int pr, int pc, int r, int c, int l){
		int rl = pr-r;
		int cl = pc-c;
		int pcl = rl*rl + cl*cl;
		return pcl < l*l;
	}
}