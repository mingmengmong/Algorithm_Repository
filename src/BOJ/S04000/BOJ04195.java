package BOJ.S04000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ04195 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int n1;
		public int n2;
		public int l;
		
		public Node(int n1, int n2, int l) {
			this.n1 = n1;
			this.n2 = n2;
			this.l = l;
		}
		public String toString(){
			return String.format("%d-%d, %d", n1,n2,l);
		}
	}
	
	public static int find(int a){
		if(arr[a] == a){
			return a;
		}
		return arr[a] = find(arr[a]);
	}
	
	public static void union(int a, int b){
		a = find(a);
		b = find(b);
		if(a != b){
			arr[b] = a;
			arr2[a] += arr2[b];
		}
	}
	
	public static int[] arr;
	public static int[] arr2;
	public static Map<String, Integer> map;
	public static int cnt;
	
	public static void BOJ04195(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int[200001];
			arr2 = new int[200001];
			for(int i=1; i<=200000; ++i){
				arr[i] = i;
				arr2[i] = 1;
			}
			
			map = new HashMap<>();
			cnt = 0;
			
			while(N-- > 0){
				st = new StringTokenizer(br.readLine());
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				
				int n1 = getNum(str1);
				int n2 = getNum(str2);
				
				n1 = find(n1);
				n2 = find(n2);
				
				if(n1 != n2){
					union(n1, n2);
				}
				
				bw.write(arr2[n1] + "\n");
//				bw.write(arr.toString() + "\n");
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int getNum(String str){
		if(map.containsKey(str)){
			return map.get(str);
		}else{
			++cnt;
			map.put(str, cnt);
			return cnt;
		}
	}
}