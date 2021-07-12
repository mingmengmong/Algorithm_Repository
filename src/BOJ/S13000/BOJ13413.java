package BOJ.S13000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ13413 {
	public static void BOJ13413(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int tc=0; tc<TC; ++tc){
			int l = sc.nextInt();
			String a = sc.next();
			String b = sc.next();
			
			int n1 = 0;
			int n2 = 0;
			for(int i=0; i<l; ++i){
				if(a.charAt(i) != b.charAt(i)){
					if(a.charAt(i) == 'B'){
						++n1;
					}else{
						++n2;
					}
				}
			}
			int min = Math.min(n1,n2);
			int max = Math.max(n1,n2);
			System.out.println(min+max-min);
		}
		
		sc.close();
		br.close();
	}
}