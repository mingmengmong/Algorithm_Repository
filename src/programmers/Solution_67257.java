package programmers;
import java.util.*;

public class Solution_67257 {
	
	/**
	 * url : https://programmers.co.kr/learn/courses/30/lessons/67257?language=java
	 * name : 수식 최대화
	 */
	
	List<Character> operators;
	int operatorCnt;
	List<String> operatorList = new ArrayList<>();
	char[] arr = new char[3];
	boolean[] visit = new boolean[3];
	
	void makeOperatorList(int idx){
		if(idx == operatorCnt){
			String str = "";
			for(int i=0; i<idx; ++i)
				str += arr[i];
			operatorList.add(str);
			
			return;
		}
		
		for(int i=0; i<operatorCnt; ++i){
			if(!visit[i]){
				visit[i] = true;
				
				arr[idx] = operators.get(i);
				makeOperatorList(idx+1);
				
				visit[i] = false;
			}
		}
	}
	
	long cal(long n1, char oper, long n2){
		if(oper == '+'){
			return n1 + n2;
		}else if(oper == '-'){
			return n1 - n2;
		}else{
			return n1 * n2;
		}
	}
	
	public long solution(String expression) {
		StringTokenizer operatorST = new StringTokenizer(expression, "1234567890");
		StringTokenizer numST = new StringTokenizer(expression, "+-*");
		
		List<Character> baseOperatorList = new ArrayList<>();
		List<Long> baseNumList = new ArrayList<>();
		Set<Character> operatorSet = new HashSet<>();
		
		while(numST.hasMoreTokens())
			baseNumList.add(Long.parseLong(numST.nextToken()));
		while(operatorST.hasMoreTokens()) {
			char c = operatorST.nextToken().charAt(0);
			baseOperatorList.add(c);
			operatorSet.add(c);
		}
		
		operators = new ArrayList<>(operatorSet);
		operatorCnt = operators.size();
		makeOperatorList(0);
		
		long res = 0;
		for(String operatorPriority : operatorList){
			List<Long> numList = new ArrayList<>(baseNumList);
			List<Character> operList = new ArrayList<>(baseOperatorList);
			
			for(char calOperator : operatorPriority.toCharArray()){
				for(int i=0; i<operList.size(); ++i){
					char oper = operList.get(i);
					if(oper == calOperator){
						long n1 = numList.remove(i);
						long n2 = numList.remove(i);
						numList.add(i, cal(n1, oper, n2));
						operList.remove(i);
						--i;
					}
				}
			}
			
			res = Math.max(res, Math.abs(numList.get(0)));
		}
		
		return res;
	}
}