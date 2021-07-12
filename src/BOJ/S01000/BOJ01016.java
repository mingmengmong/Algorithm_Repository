package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01016 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ01016(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());
		int size = ((Number)(max-min)).intValue() + 1;
		boolean[] arr = new boolean[size];
		
		boolean[] bArr = new boolean[1001001];
		List<Long> list = new ArrayList<>();
		for(int i=2; i<=1001000; ++i){
			if(bArr[i]){
				continue;
			}
			
			if(i*i > max){
				break;
			}
			
			list.add((long)i*(long)i);
			for(int j=2; j*i <= 1001000; ++j){
				bArr[j*i] = true;
			}
		}
		
		int cnt = 0;
		for(long nn : list){
			for(long j=(min/nn)*nn; j<=max; j+=nn){
				if(j<min){
					continue;
				}
				int idx = (int)(j-min);
				if(!arr[idx]){
					arr[idx] = true;
					++cnt;
				}
			}
		}
		
		System.out.println(size-cnt);
		
		
		
		sc.close();
		bw.close();
		br.close();
	}
}