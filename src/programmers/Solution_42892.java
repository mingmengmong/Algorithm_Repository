import java.util.*;
import java.util.stream.*;


public class Solution {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/42892
	 * name : 길 찾기 게임
	 */
	
	class Node{
		public int id, r, c, idx;
		public Node left, right;
		public Node(int id, int r, int c){
			this.id = id;
			this.r = r;
			this.c = c;
			this.idx = 0;
			this.left = null;
			this.right = null;
		}
		
		public void init(int l, int r, int lv){
			if(lv == height.size()) return;
			List<Node> list = map.get(height.get(lv));
			if(list.isEmpty()) return;
			
			int leftIdx = -1;
			int rightIdx = -1;
			for(int i=0; i<list.size(); ++i){
				Node iter = list.get(i);
				if(l <= iter.idx && iter.idx < this.idx){
					// left
					leftIdx = i;
				}else if(this.idx < iter.idx && iter.idx <= r){
					// right
					rightIdx = i;
				}
			}
			
			if(rightIdx != -1){
				this.right = list.remove(rightIdx);
				this.right.init(this.idx+1, r, lv+1);
			}
			
			if(leftIdx != -1){
				this.left = list.remove(leftIdx);
				this.left.init(l, this.idx-1, lv+1);
			}
		}
		
		public void inorderPrint(){
			if(this.left != null) this.left.inorderPrint();
			System.out.print(this.id + " ");
			if(this.right != null) this.right.inorderPrint();
		}
		
		public void preorder(){
			preorder.add(this.id);
			if(this.left != null) this.left.preorder();
			if(this.right != null) this.right.preorder();
		}
		
		public void postorder(){
			if(this.left != null) this.left.postorder();
			if(this.right != null) this.right.postorder();
			postorder.add(this.id);
		}
	}
	
	List<Integer> preorder = new ArrayList<>();
	List<Integer> postorder = new ArrayList<>();
	
	int N;
	Node[] arr;
	Node head;
	List<Integer> height;
	Map<Integer, List<Node>> map;
//	int[] par;
	
	public int[][] solution(int[][] nodeInfo) {
		N = nodeInfo.length;
		arr = new Node[N];
		head = new Node(0,-1,-1);
		height = new ArrayList<>();
		map = new HashMap<>();
		for(int i=0; i<N; ++i){
			int h = nodeInfo[i][1];
			if(!map.containsKey(h)){
				height.add(nodeInfo[i][1]);
				map.put(h, new ArrayList<>());
			}
			Node node = new Node(i+1, nodeInfo[i][0], nodeInfo[i][1]);
			map.get(h).add(node);
			arr[i] = node;
			if(node.c > head.c){
				head = node;
			}
		}
		
		Arrays.sort(arr, (n1, n2) -> Integer.compare(n1.r, n2.r));
		height.sort((i1, i2) -> Integer.compare(i2,i1));
		for(int h : height){
			map.get(h).sort((n1,n2)->Integer.compare(n1.r, n2.r));
		}
		
		for(int i=0; i<N; ++i){
			arr[i].idx = i;
//			System.out.printf("%d : (%d, %d)\n", arr[i].id, arr[i].r, arr[i].c);
		}
		
		head.init(0, N-1, 1);
		head.preorder();
		head.postorder();
		
		int[][] answer = {
				preorder.stream().flatMapToInt(IntStream::of).toArray(),
				postorder.stream().flatMapToInt(IntStream::of).toArray()
		};
		return answer;
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		s.solution(new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
		System.out.println();
		//
	}
}