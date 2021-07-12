package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ01252 {
	public static String s1;
	public static String s2;
	
	public static void BOJ01252(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String[] strSpl = br.readLine().split(" ");
		s1 = getReverseNumStr(strSpl[0]);
		s2 = getReverseNumStr(strSpl[1]);
		
		swap();
		
		int n = 0;
		for(int i=0; i<s1.length(); ++i){
			int n1 = s1.charAt(i)-'0';
			int n2 = i<s2.length() ? s2.charAt(i)-'0' : 0;
			
			sb.append((n1+n2+n)%2);
			n = (n1+n2+n) / 2;
		}
		
		if(n > 0) {
			sb.append(n);
		}
		
		System.out.println(sb.reverse().toString());
		
		br.close();
	}
	
	public static String getReverseNumStr(String s){
		int l = s.length();
		int i = 0;
		for(; i<l; ++i){
			if(s.charAt(i) == '1'){
				break;
			}
		}
		
		if(i != l) {
			s = s.substring(i);
		}else{
			return "0";
		}
		return new StringBuffer(s).reverse().toString();
	}
	
	public static void swap(){
		if(s1.length() < s2.length()){
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
	}
}
