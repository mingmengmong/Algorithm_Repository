package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02357 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Pair{
		public int min;
		public int max;
		public Pair(int min, int max){
			this.min = min;
			this.max = max;
		}
	}
	
	public static class Segment{
		public int size;
		public int[] sgmMinArr;
		public int[] sgmMaxArr;
		
		public Segment(int size, int[] arr){
			init(size, arr);
		}
		
		public void init(int size, int[] arr){
			this.size = size;
			sgmMinArr = new int[size * 4];
			sgmMaxArr = new int[size * 4];
			init(arr, 0, size-1, 1);
		}
		
		public void init(int[] arr, int left, int right, int idx){
			if(left == right){
				sgmMinArr[idx] = arr[left];
				sgmMaxArr[idx] = arr[left];
				return;
			}
			
			int mid = (left + right) >>> 1;
			int mulIdx = idx << 1;
			init(arr, left, mid, mulIdx);
			init(arr, mid+1, right, mulIdx+1);
			sgmMinArr[idx] = Math.min(sgmMinArr[mulIdx], sgmMinArr[mulIdx+1]);
			sgmMaxArr[idx] = Math.max(sgmMaxArr[mulIdx], sgmMaxArr[mulIdx+1]);
		}
		
		public Pair find(int left, int right){
			return find(left, right, 0, size-1, 1);
		}
		
		public Pair find(int left, int right, int leftIdx, int rightIdx, int idx){
			if(rightIdx < left || right < leftIdx){
				return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
			}
			if(left <= leftIdx && rightIdx <= right){
				return new Pair(sgmMinArr[idx], sgmMaxArr[idx]);
			}
			
			int midIdx = (leftIdx + rightIdx) >>> 1;
			int mulIdx = idx << 1;
			Pair lp = find(left, right, leftIdx, midIdx, mulIdx);
			Pair rp = find(left, right, midIdx+1, rightIdx, mulIdx+1);
			return new Pair(Math.min(lp.min, rp.min), Math.max(lp.max, rp.max));
		}
	}
	
	public static void BOJ02357(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int exe = Integer.parseInt(st.nextToken());
		int[] arr = new int[size];
		for(int i=0; i<size; ++i){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Segment sgm = new Segment(size, arr);
		
		while(exe-- > 0){
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			Pair p = sgm.find(l,r);
			bw.write(String.format("%d %d\n", p.min, p.max));
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}