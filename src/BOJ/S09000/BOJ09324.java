package BOJ.S09000;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ09324 {
	public static void BOJ09324(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; ++tc){
			char[] str = br.readLine().toCharArray();
			int[] arr = new int[26];
			boolean b = true;
			
			boolean pb = false;
			char pc = 0;
			for(char c : str){
				if(pb){
					if(pc == c){
						pb = false;
						pc = 0;
						arr[c-'A'] = 0;
						continue;
					}else{
						b = false;
						break;
					}
				}
				
				arr[c-'A']++;
				
				if(arr[c-'A'] == 3){
					pb = true;
					pc = c;
				}
			}
			
			System.out.println(b && !pb ? "OK" : "FAKE");
		}
		
		br.close();
	}
}
