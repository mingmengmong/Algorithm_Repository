package BOJ.S14000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14003 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int[] arr, idxArr;
	public static List<Integer> list = new ArrayList<>();
	
	public static void BOJ14003(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		//sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		idxArr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; ++i){
			int num = arr[i];
			int idx = lowerBound(0, list.size(), num);
			idxArr[i] = idx;
			if(idx == list.size()) list.add(num);
			else list.set(idx, num);
		}
		
		int size = list.size();
		System.out.println(size);
		
		int[] result = new int[size];
		for(int i=N-1, idx=size-1; i>=0 && idx>=0; --i){
			if(idxArr[i] == idx){
				result[idx] = arr[i];
				--idx;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int num : result) sb.append(num + " ");
		System.out.println(sb);
		
		br.close();
		bw.close();
		sc.close();
	}
	
	public static int lowerBound(int s, int e, int num){
		while(s < e){
			int m = (s+e) >>> 1;
			int mm = list.get(m);
			if(num <= mm) e = m;
			else s = m+1;
		}
		return s;
	}
	
	/*
	재채점 TimeOut 소스
	public static class Node {
		public int t;
		public int at;
		
		public Node(int t, int at) {
			this.t = t;
			this.at = at;
		}
	}
	
	
	public static void BOJ14003(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] arr2 = new int[N+1];
		int[] arr3 = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int l = 0;
		for(int i=1; i<=N; ++i){
			int n = Integer.parseInt(st.nextToken());
			int pos = lowerBound(arr, 1, 1+l, n);
			arr[pos] = n;
			arr2[i] = pos;
			arr3[i] = n;
			if(pos == l+1){
				++l;
			}
		}
		
		System.out.println(l);
		
		StringBuilder sb = new StringBuilder();
		for(int i=N; i>0; --i){
			if(l == arr2[i]){
				sb.insert(0, arr3[i]+" ");
				--l;
			}
		}
		System.out.println(sb);
		
		sc.close();
		br.close();
		bw.close();
	}
	
	public static int upperBound(int arr[], int front, int rear, int key){
		int mid;
		while(front<rear){
			mid = (front + rear) / 2;
			if(arr[mid] <= key) front = mid + 1;
			else rear = mid;
		}
		return rear;
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
	 */
}