package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02042 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Segment{
		public int size;
		public BigDecimal[] sgmArr;
		
		public Segment(int size, long[] arr){
			init(size, arr);
		}
		
		public void init(int size, long[] arr){
			this.size = size;
			sgmArr = new BigDecimal[size * 4];
			init(arr, 0, size-1, 1);
		}
		
		public void init(long[] arr, int left, int right, int idx){
			if(left == right){
				sgmArr[idx] = new BigDecimal(arr[left]);
				return;
			}
			
			int mid = (left + right) >>> 1;
			int mulIdx = idx << 1;
			init(arr, left, mid, mulIdx);
			init(arr, mid+1, right, mulIdx+1);
			sgmArr[idx] = sgmArr[mulIdx].add(sgmArr[mulIdx+1]);
		}
		
		public void update(long diff, int idx){
			update(diff, idx, 0, size-1, 1);
		}
		
		public void update(long diff, int cIdx, int left, int right, int idx){
			if(cIdx < left || right < cIdx){
				return;
			}
			sgmArr[idx] = sgmArr[idx].add(BigDecimal.valueOf(diff));
			
			if(left == right){
				return;
			}
			
			int mid = (left + right) >>> 1;
			int mulIdx = idx << 1;
			update(diff, cIdx, left, mid, mulIdx);
			update(diff, cIdx, mid+1, right, mulIdx+1);
		}
		
		public String find(int left, int right){
			return find(left, right, 0, size-1, 1).toString();
		}
		
		public BigDecimal find(int left, int right, int leftIdx, int rightIdx, int idx){
			if(rightIdx < left || right < leftIdx){
				return BigDecimal.ZERO;
			}
			if(left <= leftIdx && rightIdx <= right){
				return sgmArr[idx];
			}
			
			int midIdx = (leftIdx + rightIdx) >>> 1;
			int mulIdx = idx << 1;
			return find(left, right, leftIdx, midIdx, mulIdx).add(find(left, right, midIdx+1, rightIdx, mulIdx+1));
		}
	}
	
	public static void BOJ02042(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int exe = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		long[] arr = new long[size];
		for(int i=0; i<size; ++i){
			arr[i] = Long.parseLong(br.readLine());
		}
		
		Segment sgm = new Segment(size, arr);
		
		while(exe-- > 0){
			st = new StringTokenizer(br.readLine());
			int mode = Integer.parseInt(st.nextToken());
			if(mode == 1){
				// update
				int idx = Integer.parseInt(st.nextToken()) - 1;
				long num = Long.parseLong(st.nextToken());
				long diff = num - arr[idx];
				arr[idx] = num;
				sgm.update(diff, idx);
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