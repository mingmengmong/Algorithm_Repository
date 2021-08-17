package programmers;
import java.util.*;


public class Solution_72412 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/72412
	 * name : 순위 검색
	 */
	
	
	/*
	0 : cpp, java, python   3
	1 : backend, frontend   2
	2 : junior, senior      2
	3 : chicken, pizza      2
	4 : 1 이상 100,000 이하
	 */
	
	static List<Integer>[][][][] list = new List[3][2][2][2];
	static Map<String, Integer> map = new HashMap<>();
	static{
		map.put("-", -1);
		map.put("cpp", 0); map.put("java", 1); map.put("python", 2);
		map.put("backend",0); map.put("frontend",1);
		map.put("junior",0); map.put("senior",1);
		map.put("chicken",0); map.put("pizza",1);
		
		for(int i1=0; i1<3; ++i1)
			for(int i2=0; i2<2; ++i2)
				for(int i3=0; i3<2; ++i3)
					for(int i4=0; i4<2; ++i4)
						list[i1][i2][i3][i4] = new ArrayList<>();
	}
	
	//           depth =  0       1       2       3       4
	int findPeopleCnt(int i1, int i2, int i3, int i4, int grade, int depth){
		int res = 0;
		if(depth == 4){
			return lowerBoundCnt(list[i1][i2][i3][i4], grade);
		}else if(depth == 0 && i1 == -1){
			for(int i=0; i<3; ++i)
				res += findPeopleCnt(i,i2,i3,i4,grade,1);
		}else if(depth == 1 && i2 == -1){
			for(int i=0; i<2; ++i)
				res += findPeopleCnt(i1,i,i3,i4,grade,2);
		}else if(depth == 2 && i3 == -1){
			for(int i=0; i<2; ++i)
				res += findPeopleCnt(i1,i2,i,i4,grade,3);
		}else if(depth == 3 && i4 == -1){
			for(int i=0; i<2; ++i)
				res += findPeopleCnt(i1,i2,i3,i,grade,4);
		}else{
			res += findPeopleCnt(i1,i2,i3,i4,grade,depth+1);
		}
		return res;
	}
	
	int lowerBoundCnt(List<Integer> arr, int n){
		int l=0,r=arr.size();
		while(l<r){
			int mid = (l+r) >>> 1;
			if(n <= arr.get(mid)) r = mid;
			else l = mid+1;
		}
		return arr.size() - l;
	}
	
	public int[] solution(String[] info, String[] query) {
		for(String iter : info){
			StringTokenizer st = new StringTokenizer(iter);
			int i1 = map.get(st.nextToken());
			int i2 = map.get(st.nextToken());
			int i3 = map.get(st.nextToken());
			int i4 = map.get(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			list[i1][i2][i3][i4].add(grade);
		}
		
		for(int i1=0; i1<3; ++i1)
			for(int i2=0; i2<2; ++i2)
				for(int i3=0; i3<2; ++i3)
					for(int i4=0; i4<2; ++i4)
						list[i1][i2][i3][i4].sort(Integer::compareTo);
		
		int[] answer = new int[query.length];
		for(int i=0; i<query.length; ++i){
			StringTokenizer st = new StringTokenizer(query[i].replaceAll("(and )", ""));
			int i1 = map.get(st.nextToken());
			int i2 = map.get(st.nextToken());
			int i3 = map.get(st.nextToken());
			int i4 = map.get(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			answer[i] = findPeopleCnt(i1,i2,i3,i4,grade,0);
		}
		
		return answer;
	}
	
	public static void main(String[] args) throws Exception {
//		Solution s = new Solution();
//		System.out.println(Arrays.toString(s.solution(new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"})));
	}
}