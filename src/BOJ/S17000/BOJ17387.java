package BOJ.S17000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17387 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static long[] x = {0L,0L,0L,0L};
	public static long[] y = {0L,0L,0L,0L};
	
	public static long ccw(int i1, int i2, int i3){
		long temp = x[i1]*y[i2]+x[i2]*y[i3]+x[i3]*y[i1];
		temp = temp - y[i1]*x[i2]-y[i2]*x[i3]-y[i3]*x[i1];
		if (temp > 0) {
			return 1L;
		} else if (temp < 0) {
			return -1L;
		} else {
			return 0L;
		}
	}
	
	public static void BOJ17387(String[] args) throws Exception {
		br = new BufferedReader(new FileReader("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		sc = new Scanner(new File("/Users/gimmyeongsu/Desktop/Intellij/BOJ/src/input"));
		
		for(int i=0; i<4; ++i){
			x[i] = sc.nextLong();
			y[i] = sc.nextLong();
		}
		
		long r1 = ccw(0,1, 2);
		long r2 = ccw(0,1, 3);
		long r3 = ccw(2,3, 0);
		long r4 = ccw(2,3, 1);
//		System.out.printf("%d %d %d %d\n", r1,r2,r3,r4);
		
		if(r1 == 0 || r2 == 0 || r3 == 0 || r4 == 0){
			long minL1x = Math.min(x[0], x[1]);
			long maxL1x = Math.max(x[0], x[1]);
			long minL2x = Math.min(x[2], x[3]);
			long maxL2x = Math.max(x[2], x[3]);
			
			long minL1y = Math.min(y[0], y[1]);
			long maxL1y = Math.max(y[0], y[1]);
			long minL2y = Math.min(y[2], y[3]);
			long maxL2y = Math.max(y[2], y[3]);
			
			int res = 0;
			if(r1 == 0 && (minL1x <= x[2] && x[2] <= maxL1x) && (minL1y <= y[2] && y[2] <= maxL1y)){
				res = 1;
			}
			if(r2 == 0 && (minL1x <= x[3] && x[3] <= maxL1x) && (minL1y <= y[3] && y[3] <= maxL1y)){
				res = 1;
			}
			if(r3 == 0 && (minL2x <= x[0] && x[0] <= maxL2x) && (minL2y <= y[0] && y[0] <= maxL2y)){
				res = 1;
			}
			if(r4 == 0 && (minL2x <= x[1] && x[1] <= maxL2x) && (minL2y <= y[1] && y[1] <= maxL2y)){
				res = 1;
			}
			
			System.out.println(res);
			
		}else if(r1*r2 < 0 && r3*r4 < 0){
			System.out.println(1);
		}else{
			System.out.println(0);
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}