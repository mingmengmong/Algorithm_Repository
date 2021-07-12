package BOJ.S03000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ03780 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int idx;
		public int l;
	}
	
	public static int find(int a){
		if(arr[a] == a){
			return a;
		}
		int p = arr[a];
//		System.out.printf("%d - %d, %d\n", a,p,arr2[a]);
		arr[a] = find(p);
		arr2[a] += arr2[p];
		return arr[a];
	}
	
	public static void union(int a, int b, int l){
		a = find(a);
		int bp = find(b);
		if(a != bp){
			arr[a] = bp;
			arr2[a] += l + arr2[b];
		}
	}
	
	public static int[] arr;
	public static int[] arr2;
	
	public static void BOJ03780(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			arr2 = new int[N+1];
			for(int i=1; i<=N; ++i){
				arr[i] = i;
			}
			
			while(true){
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				if ("O".equals(cmd)) {
					break;
				}else if("E".equals(cmd)){
					int n = Integer.parseInt(st.nextToken());
//					System.out.println("\n");
//					System.out.println("n : " + n );
//					System.out.printf("%d : %d %d\n", 13,arr[13],arr2[13]);
//					System.out.printf("%d : %d %d\n", 19,arr[19],arr2[19]);
//					System.out.printf("%d : %d %d\n", 6,arr[6],arr2[6]);
//					System.out.printf("%d : %d %d\n", 17,arr[17],arr2[17]);
//					System.out.printf("%d : %d %d\n", 2,arr[2],arr2[2]);
//					System.out.printf("%d : %d %d\n", 18,arr[18],arr2[18]);
//					System.out.printf("%d : %d %d\n", 12,arr[12],arr2[12]);
//					System.out.println();
					find(n);
//					System.out.printf("%d : %d %d\n", 13,arr[13],arr2[13]);
//					System.out.printf("%d : %d %d\n", 19,arr[19],arr2[19]);
//					System.out.printf("%d : %d %d\n", 6,arr[6],arr2[6]);
//					System.out.printf("%d : %d %d\n", 17,arr[17],arr2[17]);
//					System.out.printf("%d : %d %d\n", 2,arr[2],arr2[2]);
//					System.out.printf("%d : %d %d\n", 18,arr[18],arr2[18]);
//					System.out.printf("%d : %d %d\n", 12,arr[12],arr2[12]);
					bw.write(arr2[n] + "\n");
				}else if("I".equals(cmd)){
					int n1 = Integer.parseInt(st.nextToken());
					int n2 = Integer.parseInt(st.nextToken());
					int l = Math.abs(n1-n2) % 1000;
					union(n1, n2, l);
				}
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}