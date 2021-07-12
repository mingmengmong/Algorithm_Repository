package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ01032 {
	public static void BOJ01032(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			list.add(br.readLine());
		}
		
		String stand = list.get(0);
		int length = stand.length();
		for(int i=0; i<length; ++i){
			char c = stand.charAt(i);
			boolean b = true;
			for(String str : list){
				if(str.charAt(i) != c){
					b = false;
					break;
				}
			}
			sb.append( (b ? c : '?') );
		}
		System.out.println(sb);
		
		br.close();
	}
}
