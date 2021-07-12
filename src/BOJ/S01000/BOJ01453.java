package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ01453 {
	public static void BOJ01453(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		String[] strSpl = br.readLine().split(" ");
		
		boolean[] arr = new boolean[100];
		int result = 0;
		for(int i=0; i<N; ++i){
			int n = Integer.parseInt(strSpl[i])-1;
			if(arr[n]){
				result++;
			}
			arr[n] = true;
		}
		System.out.println(result);
		
		br.close();
	}
}
