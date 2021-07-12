package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ01977 {
	public static void BOJ01977(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		boolean[] bArr = new boolean[10001];
		for(int i=1; i<=100; ++i){
			bArr[i*i] = true;
		}
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean b = false;
		int sum = 0;
		int min = 100000;
		for(int i=M; i<=N; ++i){
			if(bArr[i]){
				sum += i;
				if(!b){
					min = i;
				}
				
				b = true;
			}
		}
		
		if(b){
			System.out.println(sum);
			System.out.println(min);
		}else{
			System.out.println(-1);
		}
		
		br.close();
	}
}
