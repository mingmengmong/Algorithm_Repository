package BOJ.S13000;
import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ13305 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	public static void BOJ13305(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		BigInteger res = BigInteger.ZERO;
		long oil = 1_000_000_000;
		
		int N = Integer.parseInt(br.readLine())-1;
		StringTokenizer roadSt = new StringTokenizer(br.readLine());
		StringTokenizer oilSt = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			long road = Long.parseLong(roadSt.nextToken());
			oil = Math.min(oil, Long.parseLong(oilSt.nextToken()));
			res = res.add(BigInteger.valueOf( road * oil ));
		}
		
		System.out.println(res);
		
		br.close();
		bw.close();
		sc.close();
	}
}