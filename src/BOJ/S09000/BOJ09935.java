package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ09935 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ09935(String[] args) throws Exception {
		char[] str = br.readLine().toCharArray();
		int sl = str.length;
		char[] bomb = br.readLine().toCharArray();
		int bl = bomb.length;
		char bc = bomb[bl-1];
		char[] result = new char[sl];
		int idx = 0;
		for(int i=0; i<sl; ++i){
			result[idx++] = str[i];
			if(str[i] == bc && idx >= bl){
				boolean b = false;
				for(int j=0; j<bl; ++j){
					if(result[idx-bl+j] != bomb[j]){
						b=true;
						break;
					}
				}
				if(b){
					continue;
				}
				
				idx -= bl;
			}
		}
		
		if(idx == 0){
			System.out.println("FRULA");
		}else{
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<idx; ++i){
				sb.append(result[i]);
			}
			System.out.println(sb);
		}
		
		sc.close();
		bw.close();
		br.close();
	}
}