package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ15947 {
	public static void BOJ15947(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String[] strArr = {
				"baby", "sukhwan", "tururu", "turu",
				"very", "cute", "tururu", "turu",
				"in", "bed", "tururu", "turu",
				"baby", "sukhwan"
		};
		boolean[] boolArr = {
				false, false, true, true,
				false, false, true, true,
				false, false, true, true,
				false, false
		};
		int[] intArr = {
			-1, -1, 2, 1,
			-1, -1, 2, 1,
			-1, -1, 2, 1,
			-1, -1
		};
		int size = 14;
		
		
		int N = sc.nextInt();
		--N;
		int loop = N/14;
		int index = N%14;
		
		if(boolArr[index]){
			int loopRUCnt = intArr[index] + loop;
			if(loopRUCnt < 5){
				bw.write("tu");
				for(int i=0; i<loopRUCnt; ++i){
					bw.write("ru");
				}
			}else{
				bw.write("tu+ru*" + loopRUCnt);
			}
			bw.flush();
		}else{
			System.out.println(strArr[index]);
		}
		
		
		sc.close();
		bw.close();
		br.close();
	}
}