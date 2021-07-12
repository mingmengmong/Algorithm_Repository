package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11505 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int mod = 1000000007;
	
	public static class Segment{
		public int size;
		public long[] sgmArr;
		
		public Segment(int size, int[] arr){
			init(size, arr);
		}
		
		public void init(int size, int[] arr){
			this.size = size;
			sgmArr = new long[size * 4];
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
			sgmArr[idx] = (sgmArr[mulIdx] * sgmArr[mulIdx+1]) % mod;
		}
		
		public void update(int prev, int now, int idx){
			update(prev, now, idx, 0, size-1, 1);
		}
		
		public void update(int prev, int now, int cIdx, int left, int right, int idx){
			if(cIdx < left || right < cIdx){
				return;
			}
			if(left == right){
				sgmArr[idx] = now;
				return;
			}
			
			int mid = (left + right) >>> 1;
			int mulIdx = idx << 1;
			update(prev, now, cIdx, left, mid, mulIdx);
			update(prev, now, cIdx, mid+1, right, mulIdx+1);
			sgmArr[idx] = (sgmArr[mulIdx] * sgmArr[mulIdx+1]) % mod;
		}
		
		public long find(int left, int right){
			return find(left, right, 0, size-1, 1);
		}
		
		public long find(int left, int right, int leftIdx, int rightIdx, int idx){
			if(rightIdx < left || right < leftIdx){
				return 1;
			}
			if(left <= leftIdx && rightIdx <= right){
				return sgmArr[idx];
			}
			
			int midIdx = (leftIdx + rightIdx) >>> 1;
			int mulIdx = idx << 1;
			return (find(left, right, leftIdx, midIdx, mulIdx) * find(left, right, midIdx+1, rightIdx, mulIdx+1)) % mod;
		}
	}
	
	public static void BOJ11505(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int exe = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int[] arr = new int[size];
		for(int i=0; i<size; ++i){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Segment sgm = new Segment(size, arr);
		
		while(exe-- > 0){
			st = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(st.nextToken());
			if(mode == 1){
				// update
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int num = Integer.parseInt(st.nextToken());
				sgm.update(arr[idx], num, idx);
				arr[idx] = num;
			}else{
				// result
				int l = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				bw.write(String.format("%s\n", sgm.find(l, r)));
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}