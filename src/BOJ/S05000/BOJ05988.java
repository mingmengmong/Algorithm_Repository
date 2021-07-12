package BOJ.S05000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ05988 {
	public static void BOJ05988(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; ++i){
			String str = br.readLine();
			if((str.charAt(str.length()-1)-'0') % 2 == 0){
				sb.append("even\n");
			}else{
				sb.append("odd\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
