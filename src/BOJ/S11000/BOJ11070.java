package BOJ.S11000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ11070 {
	public static void BOJ11070(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; ++tc){
			String[] strSpl = br.readLine().split(" ");
			int n = Integer.parseInt(strSpl[0]);
			int m = Integer.parseInt(strSpl[1]);
			
			int[] winArr = new int[n];
			int[] loseArr = new int[n];
			
			for(int i=0; i<m; ++i){
				strSpl = br.readLine().split(" ");
				int a = Integer.parseInt(strSpl[0]) - 1;
				int b = Integer.parseInt(strSpl[1]) - 1;
				int p = Integer.parseInt(strSpl[2]);
				int q = Integer.parseInt(strSpl[3]);
				
				winArr[a] += p;
				winArr[b] += q;
				loseArr[a] += q;
				loseArr[b] += p;
			}
			
			int[] result = new int[n];
			for(int i=0; i<n; ++i){
				int ww = winArr[i] * winArr[i];
				int ll = loseArr[i] * loseArr[i];
				
				if(ww==0 && ll==0){
					result[i] = 0;
				}else {
					double r = (double) ww / (double) (ww + ll);
					r *= 1000d;
					result[i] = new Double(r).intValue();
				}
			}
			
			Arrays.sort(result);
			System.out.println(result[n-1]);
			System.out.println(result[0]);
		}
		
		sc.close();
		br.close();
	}
}
