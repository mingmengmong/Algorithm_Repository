package BOJ.S06000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ06549 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static class Segment{
		public int size;
		public Node[] sgmArr;
		
		public Segment(int size, int[] arr){
			this.size = size;
			sgmArr = new Node[size * 4];
			init(arr, 0, size-1, 1);
		}
		
		public void init(int[] arr, int left, int right, int idx){
			if(left == right){
				sgmArr[idx] = new Node(arr[left], left);
				return;
//				return sgmArr[idx] = node;
			}
			
			int mid = (left + right) >>> 1;
			int mulIdx = idx << 1;
//			int leftNum = init(arr, left, mid, mulIdx);
//			int rightNum = init(arr, mid+1, right, mulIdx+1);
			init(arr, left, mid, mulIdx);
			init(arr, mid+1, right, mulIdx+1);
			Node leftNode = sgmArr[mulIdx];
			Node rightNode = sgmArr[mulIdx+1];
			sgmArr[idx] = returnNode(leftNode, rightNode);
		}
		
		public Node findMin(int left, int right, int leftIdx, int rightIdx, int idx){
			if(rightIdx < left || right < leftIdx){
				return new Node(Integer.MAX_VALUE, -1);
			}
			if(left <= leftIdx && rightIdx <= right){
				return sgmArr[idx];
			}
			
			int midIdx = (leftIdx + rightIdx) >>> 1;
			int mulIdx = idx << 1;
//			int result = Integer.MAX_VALUE;
//			int leftNum = findMin(left, right, leftIdx, midIdx, mulIdx);
//			int rightNum = findMin(left, right, midIdx+1, rightIdx, mulIdx+1);
//			result = Math.min(result, Math.min(leftNum, rightNum));
//			return result;
			
			Node leftNode = findMin(left, right, leftIdx, midIdx, mulIdx);
			Node rightNode = findMin(left, right, midIdx+1, rightIdx, mulIdx+1);
			return returnNode(leftNode, rightNode);
		}
		
		public Node findMin(int left, int right){
			return findMin(left, right, 0, size-1, 1);
		}
		
		private Node returnNode(Node leftNode, Node rightNode){
			int ln = leftNode.n;
			int rn = rightNode.n;
			if(ln <= rn){
				return leftNode;
			}else {
				return rightNode;
			}
		}
	}
	
	public static class Node{
		public int n;
		public int idx;
		public Node(int n, int idx) {
			this.n = n;
			this.idx = idx;
		}
		public String toString(){
			return String.format("(%d, %d)",n, idx);
		}
	}
	
	public static int[] iArr;
	public static Segment sgm;
	
	public static void BOJ06549(String[] args) throws Exception {
		while(true){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			if(N == 0){
				break;
			}

			iArr = new int[N];
			for(int i = 0; i< N; ++i){
				iArr[i] = Integer.parseInt(st.nextToken());
			}

			sgm = new Segment(N, iArr);
//			System.out.println(Arrays.toString(sgm.sgmArr));
			bw.write(maxArea(0, N-1) + "\n");
		}
		bw.flush();
		
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static long maxArea(int left, int right){
		try{
			if(iArr[left] == iArr[right]){}
		}catch (Exception e) {
			return 0;
		}

		if(left > right){
			return 0;
		}

		if(left == right){
			return iArr[left];
		}

		Node node = sgm.findMin(left, right);
		long result = (long) node.n * (long) (right - left + 1);
		result = Math.max(result, maxArea(left, node.idx-1));
		result = Math.max(result, maxArea(node.idx+1, right));
		return result;
		
//		int idx = findIdx(left, right, minH);
//		long area = (long) minH * (long) (right - left + 1);
//		long leftArea = maxArea(left, idx-1);
//		long rightArea = maxArea(idx+1, right);
//		return Math.max(area, Math.max(leftArea, rightArea));
	}

	public static int findIdx(int left, int right, int findNum){
		int mid = (left + right) >>> 1;
		if(iArr[mid] == findNum){
			return mid;
		}

		if(left == right){
			return -1;
		}

		return Math.max(findIdx(left, mid, findNum), findIdx(mid+1, right, findNum));
	}
}