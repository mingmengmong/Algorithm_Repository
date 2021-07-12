package BOJ.S18000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ18119 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ18119(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i=0; i<N; ++i){
			char[] str = br.readLine().toCharArray();
			int l = str.length;
			int num = 0;
			for(int j=0; j<l; ++j){
				num |= (1 << (str[j]-'a'));
			}
			arr[i] = num;
		}
		
		int cNum = 0x03ffffff;
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int o = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			if(o == 1){
				cNum &= (0x03ffffff ^ (1 << (c-'a')));
			}else{
				cNum |= (1<<(c-'a'));
			}
			
			int cnt = 0;
			for(int iter : arr){
				if((iter & cNum) == iter)
					++cnt;
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}