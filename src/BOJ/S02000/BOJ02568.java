package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02568 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int s;
		public int e;
		public Node(int s, int e){
			this.s = s;
			this.e = e;
		}
		public String toString(){
			return String.format("(%d,%d)", s,e);
		}
	}
	
	public static void BOJ02568(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		Node[] list = new Node[N];
		for(int i=0; i<N; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[i] = new Node(s,e);
		}
		
		Arrays.sort(list, (n1, n2) -> Integer.compare(n1.s, n2.s));
		int[] arr = new int[N+1];
		int[] arr2 = new int[N+1];
		int[] arr3 = new int[N+1];
		int l = 0;
		for(int i=1; i<=N; ++i){
			int n = list[i-1].e;
			int pos = lowerBound(arr, 1, 1+l, n);
			arr[pos] = n;
			arr2[i] = pos;
			arr3[i] = n;
			if(pos == l+1){
				++l;
			}
		}
		
		System.out.println(l);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(list));
		System.out.println();
		System.out.println();
		
		System.out.println(N-l);
		
		for(int i=N; i>0; --i){
			if(l==arr2[i]){
				arr2[i] = 0;
				--l;
			}
		}
		
		for(int i=1; i<=N; ++i) {
			if (arr2[i] > 0) {
				System.out.println(list[i-1].s);
			}
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int lowerBound(int arr[], int front, int rear, int key){
		int mid;
		while(front<rear){
			mid = (front + rear) / 2;
			if(arr[mid] < key) front = mid + 1;
			else rear = mid;
		}
		return rear;
	}
}