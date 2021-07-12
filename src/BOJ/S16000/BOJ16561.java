package BOJ.S16000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ16561 {
	public static void BOJ16561(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int r = sc.nextInt();
		if(r % 3 != 0){
			System.out.println(0);
			return;
		}
		
		r /= 3;
		int cnt = 0;
		for(int i=1; i<=r-2; ++i){
			for(int j=1; j<=r-2; ++j){
				if((i+j) < r){
					++cnt;
				}
			}
		}
		System.out.println(cnt);
		
		sc.close();
		bw.close();
		br.close();
	}
}