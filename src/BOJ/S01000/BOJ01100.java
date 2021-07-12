package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ01100 {
	public static void BOJ01100(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int r = 0;
		for(int i=0; i<8; ++i){
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<4; ++j){
				if(str[i%2 + j*2] == 'F'){
					++r;
				}
			}
		}
		System.out.println(r);
		
		sc.close();
		br.close();
	}
}