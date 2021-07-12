package BOJ.S10000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10868 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Segment{
		public int size;
		public int[] sgmArr;
		
		public Segment(int size, int[] arr){
			init(size, arr);
		}
		
		public void init(int size, int[] arr){
			this.size = size;
			sgmArr = new int[size * 4];
			init(arr, 0, size-1, 1);
		}
		
		public void init(int[] arr, int left, int right, int idx){
			if(left == right){
				sgmArr[idx] = arr[left];
				return;
			}
			
			int mid = (left + right) >>> 1;
			int mulIdx = idx << 1;
			init(arr, left, mid, mulIdx);
			init(arr, mid+1, right, mulIdx+1);
			sgmArr[idx] = Math.min(sgmArr[mulIdx], sgmArr[mulIdx+1]);
		}
		
		public int find(int left, int right){
			return find(left, right, 0, size-1, 1);
		}
		
		public int find(int left, int right, int leftIdx, int rightIdx, int idx){
			if(rightIdx < left || right < leftIdx){
				return Integer.MAX_VALUE;
			}
			if(left <= leftIdx && rightIdx <= right){
				return sgmArr[idx];
			}
			
			int midIdx = (leftIdx + rightIdx) >>> 1;
			int mulIdx = idx << 1;
			return Math.min(find(left, right, leftIdx, midIdx, mulIdx), find(left, right, midIdx+1, rightIdx, mulIdx+1));
		}
	}
	
	public static void BOJ10868(String[] args) throws Exception {
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
			bw.write(String.format("%d\n", sgm.find(l, r)));
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}